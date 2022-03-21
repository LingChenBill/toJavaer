package com.lc.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义注解的测试.
 *
 * @author: lingchen
 * @date: 2022/3/21
 */
public class MyAnnoTest {
    public static void main(String[] args) {
        Person person = new Person("无注解", "无注解", "无注解");
        doAnnoTest(person);
        System.out.println(person.toString());
    }

    private static void doAnnoTest(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            // 检查该属性是否使用了某个注解.
            if (field.isAnnotationPresent(MyAnno.class)) {
                MyAnno anno = field.getAnnotation(MyAnno.class);
                if (anno != null) {
                    String fieldName = field.getName();
                    try {
                        // 获取setStra()方法.
                        Method setMethod = clazz.getDeclaredMethod("set"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1), String.class);
                        // 获取注解的属性.
                        String annoValue = anno.value();

                        // System.out.println(annoValue);
                        // 重新设值.
                        setMethod.invoke(obj, annoValue);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
