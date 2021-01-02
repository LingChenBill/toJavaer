package com.lc.collections;

import lombok.extern.java.Log;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

/**
 * 使用双向映射,可以使用值查找键,也可以使用键轻松查找值.
 * @description:
 * @author: lingchen
 * @date: 2021/1/2
 */
@Log
public class Bidi {

    public static void main(String[] args) {

        BidiMap<String, String> bidi = new TreeBidiMap<>();
        bidi.put("One", "1");
        bidi.put("Two", "2");
        bidi.put("Three", "3");

        // 1.
        log.info(bidi.get("One"));
        // One.
        log.info(bidi.getKey("1"));
        // Original Map: {One=1, Three=3, Two=2}.
        log.info("Original Map: " + bidi);

        bidi.removeValue("1");
        // Modified Map: {Three=3, Two=2}.
        log.info("Modified Map: " + bidi);
        BidiMap<String, String> inverseBidiMap = bidi.inverseBidiMap();
        // Inversed Map: {2=Two, 3=Three}.
        log.info("Inversed Map: " + inverseBidiMap);

    }
}
