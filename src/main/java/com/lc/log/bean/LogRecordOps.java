package com.lc.log.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author: lingchen
 * @date: 2022/5/7
 */
@Data
@Builder
public class LogRecordOps {
    private String successLogTemplate;
    private String failLogTemplate;
    private String operatorId;
    private String bizNo;
    private String category;
    private String detail;
    private String condition;
}
