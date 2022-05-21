package com.lc.log.service;

import java.util.logging.LogRecord;

/**
 * 保存日志的接口.
 *
 * @author: lingchen
 * @date: 2022/5/21
 */
public interface ILogRecordService {

    /**
     * 保存log.
     *
     * @param logRecord
     */
    void record(LogRecord logRecord);
}
