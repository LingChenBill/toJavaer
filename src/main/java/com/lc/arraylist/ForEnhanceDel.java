package com.lc.arraylist;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 如何在遍历的同时删除ArrayList中的元素.
 * 使用增强for循环其实也可以.
 * @description:
 * @author: lingchen
 * @date: 2021/1/27
 */
@Log
public class ForEnhanceDel {

    public static void main(String[] args) {

        // 用户列表.
        List<String> userNames = new ArrayList<String>() {
            {
                add("Hollis");
                add("hollis");
                add("HollisChuang");
                add("H");
                // add("Hollis");
                // add("Hollis");
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

        // 确定在一个集合中,某个即将删除的元素只包含一个的话,可以使用增强for循环的.
        // 多个元素则不适用.
        // Exception in thread "main" java.util.ConcurrentModificationException
        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
                break;
            }
        }

        log.info(userNames.toString());
    }
}
