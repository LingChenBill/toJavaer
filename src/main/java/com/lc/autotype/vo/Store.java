package com.lc.autotype.vo;

import lombok.Data;

/**
 * JSON序列化vo.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
@Data
public class Store {

    /**
     * 姓名.
     */
    private String name;

    /**
     * 水果.
     */
    private Fruit fruit;
}
