package com.lc.log.interceptor;

import com.lc.log.aop.LogRecordOperationSource;
import com.lc.log.service.IFunctionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lingchen
 * @date: 2022/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogRecordInterceptor {

    private IFunctionService functionService;

    private String tenant;

    private LogRecordOperationSource logRecordOperationSource;

}
