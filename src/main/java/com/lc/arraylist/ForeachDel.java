package com.lc.arraylist;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何在遍历的同时删除ArrayList中的元素.
 * @description:
 * @author: lingchen
 * @date: 2021/1/27
 */
@Log
public class ForeachDel {

    public static void main(String[] args) {
        // 用户列表.
        List<String> userNames = new ArrayList<String>() {
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
        for (int i = 0; i < userNames.size(); i++) {
            if (userNames.get(i).equals("Hollis")) {
                userNames.remove(i);
            }
        }

        log.info(userNames.toString());
    }
}
