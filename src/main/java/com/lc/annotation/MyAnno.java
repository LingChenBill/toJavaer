package com.lc.annotation;


import java.lang.annotation.*;

/**
 * 一个类的某些字段上被注解标识，
 * 在读取该属性时，将注解中的默认值赋给这些属性，
 * 没有标记的属性不赋值.
 *
 * 元注解:
 * `@Retention`（表示在什么级别保存该注解信息）
 *    用于指定被修饰的注解被保留多长时间，
 *    SOURCE（注解仅存在于源码中，在 class 字节码文件中不包含）,
 *    CLASS（默认的保留策略，注解会在 class 字节码文件中存在，但运行时无法获取）,
 *    RUNTIME（注解会在 class 字节码文件中存在，在运行时可以 通过反射获取到）
 *    三种类型，如果想要在程序运行过程中通过反射来获取注解的信息需要将 Retention 设置为 RUNTIME.
 * `@Target`（表示该注解可以用于什么地方）
 * `@Documented`（将此注解包含在 javadoc 中）
 * `@Inherited`（允许子类继承父类中的注解）
 *
 * @author: lingchen
 * @date: 2022/3/21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface MyAnno {
    String value() default "有注解";
}
