package com.lc.replace;

import lombok.extern.java.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串替换.
 * @description:
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class Replace {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello world, 正则表达式 Hello world");

        // replaceAll替换符合正则的所有文字.
        log.info(matcher.replaceAll("Java"));

        // replaceFirst替换第一个符合正则的数据.
        log.info(matcher.replaceFirst("Java"));

        // 替换所有的html标签.
        Pattern patternHtml = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcherHtml = patternHtml.matcher("<a href=\"index.html\">主页</a>");
        String strHtml = matcherHtml.replaceAll("");
        log.info(strHtml);

        // 替换指定文字.
        String str = "Java目前的发展史是由{0}年一{1}年";
        String[][] object = {
                new String[]{
                        "\\{0\\}",
                        "1995"
                },
                new String[]{
                        "\\{1\\}",
                        "2020"
                }
        };

        log.info(replace(str, object));
    }

    /**
     * 替换所有的指定的[]中文字.
     * @param sourceStr
     * @param object
     * @return
     */
    public static String replace(final String sourceStr, Object[] object) {
        String temp = sourceStr;
        for (int i = 0; i < object.length; i++) {
            String[] result = (String []) object[i];
            Pattern pattern = Pattern.compile(result[0]);
            Matcher matcher = pattern.matcher(temp);
            temp = matcher.replaceAll(result[1]);
        }
        return temp;
    }
}
