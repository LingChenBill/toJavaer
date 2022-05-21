package com.lc.log;

import com.lc.log.annotation.EnableLogRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 那么接下来需要把这些组件组装起来，然后让用户去使用.
 * 在使用这个组件的时候只需要在Springboot的入口上添加一个注解@EnableLogRecord(tenant="com.lc.test”).
 *
 * @author: lingchen
 * @date: 2022/5/21
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableTransactionManagement
@EnableLogRecord(tenant = "com.lc.test")
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }
}
