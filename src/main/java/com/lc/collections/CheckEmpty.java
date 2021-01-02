package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 *
 * @description:
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class CheckEmpty {

    public static void main(String[] args) {

        List<String> list = getList();
        // false.
        log.info("Non-Empty List Check: " + checkNotEmpty(list));
        // false.
        log.info("Non-Empty List Check: " + checkNotEmpty2(list));
    }

    static List<String> getList() {
        return null;
    }

    static boolean checkNotEmpty(List<String> list) {
        return !(list == null || list.isEmpty());
    }

    static boolean checkNotEmpty2(List<String> list) {
        return CollectionUtils.isNotEmpty(list);
    }
}
