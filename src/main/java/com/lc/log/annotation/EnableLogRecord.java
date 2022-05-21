package com.lc.log.annotation;

import com.lc.log.aop.LogRecordConfigureSelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableLogRecord的代码，代码中Import了LogRecordConfigureSelector.class,
 * 在LogRecordConfigureSelector类中暴露了LogRecordProxyAutoConfiguration类.
 *
 * @author: lingchen
 * @date: 2022/5/21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogRecordConfigureSelector.class)
public @interface EnableLogRecord {

    // 代表租户, 是为了多租户使用的.
    String tenant();

    AdviceMode mode() default AdviceMode.PROXY;
}
