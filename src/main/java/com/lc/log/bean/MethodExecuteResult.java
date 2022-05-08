package com.lc.log.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lingchen
 * @date: 2022/5/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodExecuteResult {
    private boolean success;
    public Throwable throwable;
    private String errorMsg;
}
