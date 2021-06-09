package com.lc.oauth.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;

/**
 * Url参数工具类.
 *
 * @author: lingchen
 * @date: 2021/6/9
 */
public class UrlParamsUtil {

    /**
     * url参数拼接.
     *
     * @param url
     * @param params
     * @return
     */
    public static String appendParams(String url, Map<String, String> params) {

        if (StringUtils.isEmpty(url)) {
            return "";
        } else if (params.isEmpty()) {
            return url.trim();
        } else {
            StringBuffer sb = new StringBuffer("");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);

            url = url.trim();
            int length = url.length();
            int index = url.indexOf("?");
            if (index > -1) {
                // url最后一个符号为？，如：http://wwww.yy.com?
                if ((length - 1) == index) {
                    url += sb.toString();
                } else {
                    // 情况为：http://wwww.baidu.com?aa=11
                    url += "&" + sb.toString();
                }
            } else {
                // url后面没有问号，如：http://wwww.baidu.com
                url += "?" + sb.toString();
            }
            return url;
        }
    }
}
