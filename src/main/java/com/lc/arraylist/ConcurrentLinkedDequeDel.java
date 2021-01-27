package com.lc.arraylist;

import lombok.extern.java.Log;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 如何在遍历的同时删除ArrayList中的元素.
 * 直接使用fail-safe的集合类.
 * @description:
 * @author: lingchen
 * @date: 2021/1/27
 */
@Log
public class ConcurrentLinkedDequeDel {

    public static void main(String[] args) {

        // 用户列表.
        // List<String> userNames = new ArrayList<String>() {
        ConcurrentLinkedDeque<String> userNames = new ConcurrentLinkedDeque<String>() {
            {
                add("Hollis");
                add("hollis");
                add("HollisChuang");
                add("H");
                add("Hollis");
                add("Hollis");
            }
        };

        // remove操作会改变List中元素的下标,可能存在漏删的情况.
        // for (int i = 0; i < userNames.size(); i++) {
        //     if (userNames.get(i).equals("Hollis")) {
        //         userNames.remove(i);
        //     }
        // }

        // Iterator<String> iterator = userNames.iterator();
        //
        // while (iterator.hasNext()) {
        //     if (iterator.next().equals("Hollis")) {
        //         iterator.remove();
        //     }
        // }

        // userNames = userNames.stream().filter(userName -> !userName.equals("Hollis")).collect(Collectors.toList());

        // Exception in thread "main" java.util.ConcurrentModificationException

        // 由于迭代时是对原集合的拷贝进行遍历,在遍历过程中对原集合所作的修改并不能被迭代器检测到.不会触发ConcurrentModificationException.
        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }

        log.info(userNames.toString());
    }
}
