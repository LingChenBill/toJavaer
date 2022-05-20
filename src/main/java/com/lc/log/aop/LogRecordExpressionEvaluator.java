package com.lc.log.aop;

import com.lc.log.bean.LogRecordEvaluationContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: lingchen
 * @date: 2022/5/8
 */
public class LogRecordExpressionEvaluator extends CachedExpressionEvaluator {

    // SpEL	会解析成一个Expression表达式，然后根据传入的Object获取到对应的值，
    // 所以expressionCache是为了缓存方法、表达式和 SpEL 的Expression的对应关系,
    // 让方法注解上添加的SpEL表达式只解析一次.
    private Map<ExpressionKey, Expression> expressionCache = new ConcurrentHashMap<>(64);

    // targetMethodCache是为了缓存传入到Expression表达式的Object.
    private final Map<AnnotatedElementKey, Method> targetMethodCache = new ConcurrentHashMap<>(64);

    public String parseExpression(String conditionExpression,
                                  AnnotatedElementKey methodKey, EvaluationContext evalContext) {
        // getExpression方法会从expressionCache中获取到@LogRecordAnnotation注解上的表达式的解析Expression的实例,
        // 然后调用getValue方法，getValue传入一个evalContext就是类似上面例子中的order对象.
        return getExpression(this.expressionCache, methodKey, conditionExpression)
                .getValue(evalContext, String.class);
    }

    public LogRecordEvaluationContext createEvaluationContext(Method method, Object[] args,
                                                              Class targetClass, Object ret,
                                                              String errorMsg, BeanFactory beanFactory) {
        if (beanFactory == null) {
            throw new IllegalArgumentException("BeaFactory is null!");
        }
        Method targetMethod = getTargetMethod(targetClass, method);
        return new LogRecordEvaluationContext(beanFactory.getBean(targetClass), method, args,
                new DefaultParameterNameDiscoverer(), ret, errorMsg);
    }

    private Method getTargetMethod(Class targetClass, Method method) {
        AnnotatedElementKey methodKey = new AnnotatedElementKey(method, targetClass);
        Method targetMethod = this.targetMethodCache.get(methodKey);
        if (targetMethod == null) {
            targetMethod = AopUtils.getMostSpecificMethod(method, targetClass);
            if (targetMethod == null) {
                targetMethod = method;
            }
            this.targetMethodCache.put(methodKey, targetMethod);
        }
        return targetMethod;
    }
}