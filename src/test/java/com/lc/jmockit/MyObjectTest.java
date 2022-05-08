package com.lc.jmockit;

import mockit.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JMockit 也可以分类为非局部模拟与局部模拟，
 * 区分在于 Expectations 块是否有参数，有参数的是局部模拟，反之是非局部模拟.
 * @author: lingchen
 * @date: 2022/5/8
 */
public class MyObjectTest {

    // 用@Mocked 标注的对象，不需要赋值，jmockit 自动 mock .
    @Mocked
    MyObject myObject;

    @Test
    public void testHello() {
        // 录制预期模拟行为.
        new NonStrictExpectations() {
            {
                myObject.hello("Zhangsan");
                returns("Hello Zhangsan");
            }
        };

        assertEquals("Hello Zhangsan", myObject.hello("Zhangsan"));

        // 验证预期 Mock 行为被调用.
        new Verifications() {
            {
                myObject.hello("Zhangsan");
                times = 1;
            }
        };
    }


    @Test
    public void testHello2() {

        final MyObject obj = new MyObject();

        // 局部测试 - 有参数.
        new NonStrictExpectations(obj) {
            {
                obj.hello("Lisi");
                returns("Hello Lisi");
            }
        };

        // 调用测试方法.
        assertEquals("Hello Lisi", obj.hello("Lisi"));

        new Verifications() {
            {
                obj.hello("Lisi");
                times = 1;
            }
        };
    }

    /**
     * 静态方法模拟.
     */
    @Test
    public void testMockStaticMethod() {
        new NonStrictExpectations(MyObject.class) {
            {
                MyObject.getDouble(1);
                result = 3;
            }
        };

        assertEquals(3, MyObject.getDouble(1));

        new Verifications() {
            {
                MyObject.getDouble(1);
                times = 1;
            }
        };
    }

    /**
     * 测试私有方法调用.
     */
    @Test
    public void testMockPrivateMethod() {
        final MyObject obj = new MyObject();

        new NonStrictExpectations(obj) {
            {
                //如果私有方法是静态的，可以使用:
                // this.invoke(null, "multiply3")
                this.invoke(obj, "multiply3", 1);
                result = 4;
            }
        };

        // 调用方法, 方法有私有方法调用.
        String actual = obj.getTripleString(1);
        assertEquals("4", actual);

        new Verifications() {
            {
                this.invoke(obj, "multiply3", 1);
                times = 1;
            }
        };
    }

    /**
     * 测试对象私有属性.
     */
    @Test
    public void testMockPrivateProperty() {
        final MyObject obj = new MyObject();

        new NonStrictExpectations(obj) {
            {
                this.setField(obj, "name", "name changed");
            }
        };

        assertEquals("name changed", obj.getName());
    }

    /**
     * 测试私有静态属性.
     */
    @Test
    public void testMockPrivateStaticProperty() {
        new NonStrictExpectations(MyObject.class) {
            {
                this.setField(MyObject.class, "className", "classname changed");
            }
        };

        assertEquals("classname changed", MyObject.getClassName());
    }

    /**
     * 测试修改方法内容.
     */
    @Test
    public void testMockNormalMethodContent() {
        MyObject obj = new MyObject();
        new MockUp<MyObject>() {
            @Mock
            public int getDouble(int i) {
                return i * 20;
            }
        };
        assertEquals(20, obj.getDouble(1));
        assertEquals(40, obj.getDouble(2));
    }

}
