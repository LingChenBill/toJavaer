package com.lc.log.aop;

import com.lc.log.interceptor.LogRecordInterceptor;

/**
 * @author: lingchen
 * @date: 2022/5/21
 */
public class BeanFactoryLogRecordAdvisor {

    private LogRecordOperationSource logRecordOperationSource;

    private LogRecordInterceptor logRecordInterceptor;

    public void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
        this.logRecordOperationSource = logRecordOperationSource;
    }

    public void setAdvice(LogRecordInterceptor logRecordInterceptor) {
        this.logRecordInterceptor = logRecordInterceptor;
    }
}
