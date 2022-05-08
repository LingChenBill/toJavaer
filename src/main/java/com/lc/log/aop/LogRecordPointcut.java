package com.lc.log.aop;

import lombok.NonNull;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author: lingchen
 * @date: 2022/5/6
 */
public class LogRecordPointcut extends StaticMethodMatcherPointcut implements Serializable {

    private LogRecordOperationSource logRecordOperationSource;

    @Override
    public boolean matches(@NonNull Method method, @NonNull Class<?> targetClass) {
        // 解析 这个 method 上有没有 @LogRecordAnnotation 注解，有的话会解析出来注解上的各个参数.
        return !CollectionUtils.isEmpty(logRecordOperationSource.computeLogRecordOperations(method, targetClass));
    }

    void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
        this.logRecordOperationSource = logRecordOperationSource;
    }
}
