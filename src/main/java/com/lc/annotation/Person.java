package com.lc.annotation;

import lombok.Data;
import lombok.ToString;

/**
 * 使用自定义的注解.
 *
 * @author: lingchen
 * @date: 2022/3/21
 */
@Data
@ToString
public class Person {
    @MyAnno
    private String stra;
    private String strb;
    private String strc;

    public Person(String stra, String strb, String strc) {
        super();
        this.stra = stra;
        this.strb = strb;
        this.strc = strc;
    }
}
