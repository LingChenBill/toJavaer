package com.lc.serialization.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 实现接口Serializable,测试serialVersionUID.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
@Data
public class UserUid implements Serializable {

    // private static final long serialVersionUID = 1L;
    private static final long serialVersionUID = 2L;

    /**
     * 姓名.
     */
    private String name;
}
