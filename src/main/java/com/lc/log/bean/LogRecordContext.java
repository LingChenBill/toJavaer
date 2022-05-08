package com.lc.log.bean;

import java.util.Map;
import java.util.Stack;

/**
 * @author: lingchen
 * @date: 2022/5/8
 */
public class LogRecordContext {

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
