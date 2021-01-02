package com.lc.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import lombok.extern.java.Log;

import java.util.Iterator;

/**
 * Collection的迭代方法.
 * @description: 通过普通for循环迭代.
 *               通过增强for循环迭代.
 *               使用Iterator迭代.
 *               使用Stream迭代.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class ImmutableListOperator {

    public static void main(String[] args) {

        ImmutableList<String> list = ImmutableList.of("Hollis", "hollischuang");

        // 普通for.
        log.info("普通for.");
        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i));
        }

        log.info("增强for循环遍历.");
        for (String s : list) {
            log.info(s);
        }

        log.info("Iterator遍历. ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            log.info(it.next());
        }

        log.info("Stream遍历. ");
        list.forEach(log::info);
        list.stream().forEach(log::info);
    }
}
