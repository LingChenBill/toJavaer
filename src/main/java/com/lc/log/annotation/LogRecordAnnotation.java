package com.lc.log.annotation;

import java.lang.annotation.*;

/**
 * 这块逻辑主要是一个拦截器，针对@LogRecord注解分析出需要记录的操作日志,
 * 然后把操作日志持久化, 这里把注解命名为@LogRecordAnnotation.
 *
 * @author: lingchen
 * @date: 2022/5/6
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogRecordAnnotation {

    // 操作日志的文本模板. 必填.
    String success();

    // 操作日志失败的文本版本. 非必填.
    String fail() default "";

    // 操作日志的执行人. 非必填.
    String operator() default "";

    // 操作日志绑定的业务对象标识. 必填.
    String bizNo();

    // 操作日志的种类. 非必填.
    String category() default "";

    // 扩展参数，记录操作日志的修改详情. 非必填.
    String detail() default "";

    // 记录日志的条件. 非必填.
    String condition() default "";
}
