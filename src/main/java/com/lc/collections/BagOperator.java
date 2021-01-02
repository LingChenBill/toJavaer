package com.lc.collections;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * 定义了一个集合.
 * @description: 用于计算对象在集合中出现的次数.
 * @author: lingchen
 * @date: 2021/1/2
 */
public class BagOperator {

    public static void main(String[] args) {
        Bag<String> bag = new HashBag<>();
        bag.add("a", 2);
        bag.add("b");
        bag.add("c");
        bag.add("d", 3);
        // d is present 3 times.
        System.out.println("d is present " + bag.getCount("d") + " times");
        // bag: [2:a,1:b,1:c,3:d].
        System.out.println("bag: " + bag);
        // Unique Set: [a, b, c, d].
        System.out.println("Unique Set: " + bag.uniqueSet());

        bag.remove("d", 2);
        // 2 occurences of d removed from bag: [2:a,1:b,1:c,1:d]
        System.out.println("2 occurences of d removed from bag: " + bag);
        // d is present 1 times.
        System.out.println("d is present " + bag.getCount("d") + " times.");
        // bag: [2:a,1:b,1:c,1:d].
        System.out.println("bag: " + bag);
        // Unique Set: [a, b, c, d].
        System.out.println("Unique Set: " + bag.uniqueSet());

    }
}
