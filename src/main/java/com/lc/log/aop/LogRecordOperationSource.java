package com.lc.log.aop;

import com.lc.log.annotation.LogRecordAnnotation;
import com.lc.log.bean.LogRecordOps;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: lingchen
 * @date: 2022/5/7
 */
public class LogRecordOperationSource {

    public Collection<LogRecordOps> computeLogRecordOperations(Method method, Class<?> targetClass) {
        
        if (!Modifier.isPublic(method.getModifiers())) {
            return null;
        }

        Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);

        specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

        return parseLogRecordAnnotations(specificMethod);
    }

    private Collection<LogRecordOps> parseLogRecordAnnotations(AnnotatedElement specificMethod) {

        Collection<LogRecordAnnotation> logRecordAnnotations = AnnotatedElementUtils.findAllMergedAnnotations(
                specificMethod, LogRecordAnnotation.class);

        Collection<LogRecordOps> ret = null;

        if (!logRecordAnnotations.isEmpty()) {
            ret = lazyInit(ret);

            for (LogRecordAnnotation recordAnnotation : logRecordAnnotations) {
                ret.add(parseLogRecordAnnotation(specificMethod, recordAnnotation));
            }
        }

        return ret;
    }

    private Collection<LogRecordOps> lazyInit(Collection<LogRecordOps> ops) {
        return (ops != null ? ops : new ArrayList<>(1));
    }

    private LogRecordOps parseLogRecordAnnotation(AnnotatedElement ae, LogRecordAnnotation recordAnnotation) {
        LogRecordOps recordOps = LogRecordOps.builder()
                .successLogTemplate(recordAnnotation.success())
                .failLogTemplate(recordAnnotation.fail())
                .bizNo(recordAnnotation.bizNo())
                .operatorId(recordAnnotation.operator())
                .category(recordAnnotation.category())
                .detail(recordAnnotation.detail())
                .condition(recordAnnotation.condition())
                .build();

        validateLogRecordOperation(ae, recordOps);
        
        return recordOps;
    }

    private void validateLogRecordOperation(AnnotatedElement ae, LogRecordOps recordOps) {
        if (!StringUtils.hasText(recordOps.getSuccessLogTemplate())
                && !StringUtils.hasText(recordOps.getFailLogTemplate())) {
            throw new IllegalStateException("Invalid logRecord annotation configuration on" +
                    ae.toString() + "'. 'one of successTemplate and failLogTemplate' attribute must be set.");
        }
    }

}
