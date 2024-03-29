package com.lc.log.aop;

import com.lc.log.bean.LogRecordContext;
import com.lc.log.bean.LogRecordOps;
import com.lc.log.bean.MethodExecuteResult;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author: lingchen
 * @date: 2022/5/8
 */
@Log
public class LogRecordPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor implements MethodInterceptor {

    private LogRecordOperationSource logRecordOperationSource;

    public void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
        this.logRecordOperationSource = logRecordOperationSource;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();

        // 记录日志
        return execute(methodInvocation, methodInvocation.getThis(), method, methodInvocation.getArguments());
    }

    /**
     * 操作日志的记录持久化是在方法执行完之后执行的，当方法抛出异常之后会先捕获异常，
     * 等操作日志持久化完成后再抛出异常.
     * 在业务的方法执行之前，会对提前解析的自定义函数求值，
     * 解决了前面提到的需要查询修改之前的内容.
     * @param invoker
     * @param target
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    private Object execute(MethodInvocation invoker, Object target, Method method, Object[] args) throws Throwable {

        Class<?> targetClass = getTargetClass(target);
        Object ret = null;

        MethodExecuteResult methodExecuteResult = new MethodExecuteResult(true, null, "");

        LogRecordContext.putEmptySpan();

        Collection<LogRecordOps> operations = new ArrayList<>();
        Map<String, String> functionNameAndReturnMap = new HashMap<>();

        try {
            operations = logRecordOperationSource.computeLogRecordOperations(method, targetClass);
            List<String> spElTemplates = getBeforeExecuteFunctionTemplate(operations);

            //业务逻辑执行前的自定义函数解析
            functionNameAndReturnMap = processBeforeExecuteFunctionTemplate(spElTemplates, targetClass, method, args);
        } catch (Exception e) {
            log.info("log record parse before function exception" + e);
        }

        try {
            ret = invoker.proceed();
        } catch (Exception e) {
            methodExecuteResult = new MethodExecuteResult(false, e, e.getMessage());
        }

        try {
            if (!CollectionUtils.isEmpty(operations)) {
                recordExecute(ret, method, args, operations, targetClass,
                        methodExecuteResult.isSuccess(), methodExecuteResult.getErrorMsg(), functionNameAndReturnMap);
            }
        }  catch (Exception t) {
            //记录日志错误不要影响业务
            log.info("log record parse exception" + t);
        } finally {
            LogRecordContext.clear();
        }
        if (methodExecuteResult.throwable != null) {
            throw methodExecuteResult.throwable;
        }

        return ret;

    }

    private void recordExecute(Object ret, Method method, Object[] args, Collection<LogRecordOps> operations, Class<?> targetClass, boolean success, String errorMsg, Map<String, String> functionNameAndReturnMap) {

    }

    private Map<String, String> processBeforeExecuteFunctionTemplate(List<String> spElTemplates, Class<?> targetClass, Method method, Object[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();
        Map<String, String> map = new HashMap<>();

        for (String templates : spElTemplates) {
            Expression expression = parser.parseExpression(templates);

            map.put(expression.getExpressionString(), "a");
        }

        return map;
    }

    private List<String> getBeforeExecuteFunctionTemplate(Collection<LogRecordOps> operations) {

        List<String> list = new ArrayList<>();
        for (LogRecordOps op : operations) {
            list.add(op.getSuccessLogTemplate());
        }

        return list;

    }

    private Class<?> getTargetClass(Object target) {
        return target.getClass();
    }

    @Override
    public Pointcut getPointcut() {
        return new LogRecordPointcut();
    }
}
