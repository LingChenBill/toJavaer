package com.lc.generics;

import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型比较.
 *
 * @description:
 * @author: lingchen
 * @date: 2021/4/12
 */
public class Collections {

    /**
     * 获取最大值.
     * @param xs
     * @param <A>
     * @return
     */
    public static <A extends Comparable<A>> A max(Collection<A> xs) {
        Iterator<A> xi = xs.iterator();
        A w = xi.next();

        while (xi.hasNext()) {
            A x = xi.next();
            // 获取最大值.
            if (w.compareTo(x) < 0) {
                w = x;
            }
        }

        return w;
    }
}
