package com.lc.failfast;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 异常复现.
 * @description: ConcurrentModificationException: 当方法检测到对象的并发修改,但不允许这种修改时就抛出该异常.
 *               为什么禁止在foreach循环里进行元素的remove/add操作.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class CMException {

    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {
            {
                add("Hollis");
                add("hollis");
                add("HollisChuang");
                add("H");
            }
        };

        /**
         * 在增强for循环中,集合遍历是通过Iterator进行的,
         * 但是元素的add/remove却是直接使用的集合类自己的方法.
         * 这就导致iterator在遍历的时候,会发现有一个元素在自己不知不觉间就被删除/添加了.
         * 就会抛出一个异常,用来提示用户,可以发生了并发修改.
         */
        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }

        // Exception in thread "main" java.util.ConcurrentModificationException.
        log.info(userNames.toString());

    }
}
