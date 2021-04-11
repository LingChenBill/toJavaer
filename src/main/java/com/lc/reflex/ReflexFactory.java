package com.lc.reflex;

/**
 * 反射机制实现的工厂模式可以通过反射取得接口的实例
 * @description: 需要传入完整的包和类名.
 * @author: lingchen
 * @date: 2021/4/10
 */
public class ReflexFactory {
    public static void main(String[] args) {
        // fruit f = ReflexInFactory.getInstance("com.lc.reflex.Apple");
        fruit f = ReflexInFactory.getInstance("com.lc.reflex.Orange");

        if (f != null) {
            f.eat();
        }
    }
}

class ReflexInFactory {
    public static fruit getInstance(String className) {
        fruit f = null;

        try {
            f = (fruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return f;
    }
}