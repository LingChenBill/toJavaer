package com.lc.autotype.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: lingchen
 * @date: 2021/6/19
 */
@Data
public class Apple implements Fruit {

    /**
     * 价格.
     */
    private BigDecimal price;
}
