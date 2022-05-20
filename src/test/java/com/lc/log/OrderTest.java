package com.lc.log;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Spring 3提供了一个非常强大的功能：Spring	EL，
 * SpEL在Spring	产品中是作为表达式求值的核心基础模块，
 * 它本身是可以脱离 Spring 独立使用的.
 * @author: lingchen
 * @date: 2022/5/20
 */
public class OrderTest {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#root.purchaseName");
        Order order = new Order();
        order.setPurchaseName("张三");
        System.out.println(expression.getValue(order));
    }
}
