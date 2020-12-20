package com.lc.string;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串的拼接.
 *
 * @description: pom: commons-lang3.
 *  耗时时长: StringBuilder < StringBuffer < concat < + < StringUtils.join
 * @author: lingchen
 * @date: 2020/12/20
 */
@Log
public class Concat {

    public static void main(String[] args) {

        // 使用符号 + 来拼接.
        String wechat = "Hollis";
        String introduce = "每日更新Java相关技术文章";
        String hollis = wechat + ", " + introduce;
        log.info(hollis);

        // 使用concat来拼接字符串.
        String strConcat = wechat.concat(", ").concat(introduce);
        log.info(strConcat);

        // 使用StringBuffer类,它的对象是可以扩充和修改的.
        StringBuffer wechatSB = new StringBuffer("Hollis");
        StringBuffer hollisSB = wechatSB.append(", ").append(introduce);
        log.info(hollisSB.toString());

        // 使用StringBuilder类,它的对象是可以扩充和修改的.
        StringBuilder wechatBuilder = new StringBuilder("Hollis");
        StringBuilder hollisBuilder = wechatBuilder.append(", ").append(introduce);
        log.info(hollisBuilder.toString());

        // 使用: StringUtils.join, 来拼接字符串.
        log.info(StringUtils.join(wechat, ", ", introduce));

        // 使用: StringUtils.join, 最主要的功能是:将数组或集合以某拼接符拼接到一起形成新的字符串.
        String[] list = {"Hollis", "每日更新Java相关技术文章"};
        String result = StringUtils.join(list, ", ");
        log.info(result);

    }

}
