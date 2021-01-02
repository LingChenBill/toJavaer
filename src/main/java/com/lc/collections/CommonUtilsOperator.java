package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * CommonUtils类为常见操作提供了各种实用方法.
 * @description: CollectionUtils.addIgnoreNull: 忽略null.
 *               CollectionUtils.collate: sorted && merge.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class CommonUtilsOperator {

    public static void main(String[] args) {

        List<String> list = new LinkedList<String>();
        // 忽略加入null.
        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, "a");
        // [a].
        log.info(list.toString());

        if (list.contains(null)) {
            log.info("Null value is present.");
        } else {
            log.info("Null value is not present.");
        }

        List<String> sortedList1 = Arrays.asList("A", "C", "E");
        List<String> sortedList2 = Arrays.asList("B", "D", "F");
        List<String> mergedList = CollectionUtils.collate(sortedList1, sortedList2);
        // [A, B, C, D, E, F].
        log.info(mergedList.toString());
    }
}
