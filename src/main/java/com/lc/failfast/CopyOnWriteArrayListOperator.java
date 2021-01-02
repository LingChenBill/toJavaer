package com.lc.failfast;

import lombok.extern.java.Log;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * fail-safe集合类.
 * @description: fail-safe集合的所有集合的修改是先拷贝一份副本,然后在副本集合上进行的,
 *               并不是直接对原集合进行修改.
 *               并且这些修改方法,如add/remove都是通过加锁来控制并发的.
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class CopyOnWriteArrayListOperator {

    public static void main(String[] args) {

        List<String> userNames = new CopyOnWriteArrayList<String>() {
            {
                add("Hollis");
                add("hollis");
                add("HollisChuang");
                add("H");
            }
        };

        Iterator<String> it = userNames.iterator();

        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }

        // [hollis, HollisChuang, H].
        log.info(userNames.toString());

        /**
         * 虽然基于拷贝内容的优点是避免了CMException, 但同样地,迭代器并不能访问到修改后的内容.
         */
        while (it.hasNext()) {
            log.info(it.next());
        }

    }
}
