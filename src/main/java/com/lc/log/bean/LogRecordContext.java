package com.lc.log.bean;

import java.util.Map;
import java.util.Stack;

/**
 * 通过一个ThreadLocal变量保持了一个栈，
 * 栈里面是个Map，Map对应了变量的名称和变量的值.
 * @author: lingchen
 * @date: 2022/5/8
 */
public class LogRecordContext {

    // LogRecordContext	每执行一个方法都会压栈一个Map，
    // 方法执行完之后会Pop	掉这个Map，从而避免变量共享和覆盖问题.
    private static final InheritableThreadLocal<Stack<Map<String, Object>>> variableMapStack =
            new InheritableThreadLocal<>();

    public static Map<String, Object> getVariables() {
        return variableMapStack.get().pop();
    }

    public static void setVariables(Map<String, Object> variables) {
        variableMapStack.get().push(variables);
    }

    public static void putEmptySpan() {
    }

    public static void clear() {
        variableMapStack.remove();
    }

}
