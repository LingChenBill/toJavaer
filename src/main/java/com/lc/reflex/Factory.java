package com.lc.reflex;

/**
 * 不用反射机制时的工厂模式.
 * @description:缺点: 当我们再添加一个子类的时候,就需要修改工厂类了.
 *                   添加太多的子类的时候,改动就会很多.
 * @author: lingchen
 * @date: 2021/4/10
 */
// 构造工厂类.
// 也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了.
class CustomFactory {
    public static fruit getInstance(String fruitName) {
        fruit f = null;
        if ("Apple".equals(fruitName)) {
            f = new Apple();
        }

        if ("Orange".equals(fruitName)) {
            f = new Orange();
        }

        return f;
    }
}

public class Factory {
    public static void main(String[] args) {
        fruit f = CustomFactory.getInstance("Orange");
        f.eat();
    }
}