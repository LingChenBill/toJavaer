package com.lc.log.service.impl;

import com.lc.log.service.ILogRecordService;
import lombok.extern.java.Log;

import java.util.logging.LogRecord;

/**
 * 日志保存实现类.
 * 通过log.info保存在日志文件中的例子，
 * 业务可以把保存设置成异步或者同步，
 * 可以和业务放在一个事务中保证操作日志和业务的一致性，
 * 也可以新开辟一个事务，保证日志的错误不影响业务的事务.
 * 业务可以保存在Elasticsearch、数据库或者文件中,
 * 用户可以根据日志结构和日志的存储实现相应的查询逻辑.
 *
 * @author: lingchen
 * @date: 2022/5/21
 */
@Log
public class DefaultLogRecordServiceImpl implements ILogRecordService {
    @Override
    public void record(LogRecord logRecord) {
        log.info("[logRecord]log=" + logRecord);
    }
}
