package com.lc.oauth.servlet;

import com.lc.oauth.utils.UrlParamsUtil;
import lombok.extern.java.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * OAuth2.0学习.
 *
 * @author: lingchen
 * @date: 2021/6/9
 */
@Log
public class OauthServlet {

    /**
     * 模拟第三方软件注册之后的数据库存储.
     */
    static Map<String, String> appMap = new HashMap<>();

    /**
     * code Map.
     */
    static Map<String, String> codeMap = new HashMap<>();

    static {
        //模拟第三方软件注册之后的数据库存储
        appMap.put("app_id", "APPID_RABBIT");
        appMap.put("app_secret", "APPSECRET_RABBIT");
        appMap.put("redirect_uri", "http://localhost:8080/AppServlet-ch03");
        appMap.put("scope", "today history");
    }

    /**
     * 模拟OAuth2.0
     *
     * @param request
     * @param response
     * @Exception IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 回调地址.
        String redirectUri = request.getParameter("redirect_uri");
        // 权限范围.
        String scope = request.getParameter("scope");
        // 授权服务检验响应类型.
        String responseType = request.getParameter("response_type");
        // appId.
        String appId = request.getParameter("app_id");
        // 输入的权限范围.
        String[] rscope = request.getParameterValues("rscope");

        // 验证基本信息.
        if (!appMap.get("redirect_uri").equals(redirectUri)) {
            // 回调地址不存在.
            log.info("redirect uri error.");
        }

        // 验证权限信息.
        if (!checkScope(scope)) {
            // 超出注册的权限范围.
            log.info("oauth scope error.");
        }

        // 生成请求页面.

        // 验证权限信息(第二次).
        if (!checkScope(rscope)) {
            // 超出注册的权限范围.
            log.info("oauth scope error.");
        }

        // 校验授权服务检验响应类型.
        if (!"code".equals(responseType)) {
            log.info("response type error.");
        }

        // 生成code授权码.
        String code = generateCode(appId, "USERTEST");

        // code, scope绑定存储.
        Map<String, String[]> codeScopeMap = new HashMap<>(16);
        // 授权码与授权范围绑定.
        codeScopeMap.put(code, rscope);

        // 参数code.
        Map<String, String> params = new HashMap<>();
        params.put(code, code);

        // 重定向url.
        String toUrl = UrlParamsUtil.appendParams(redirectUri, params);

        // 生成码授权码的第二次重定向.
        response.sendRedirect(toUrl);
    }

    /**
     * 验证权限范围.
     *
     * @param scope
     * @return
     */
    private boolean checkScope(String scope) {

        log.info("appMap size: " + appMap.size());
        log.info("appMap scope: " + appMap.get("scope"));
        log.info("check scope: " + scope);

        return appMap.get("scope").contains(scope);
    }

    /**
     * 第二次权限范围校验.
     *
     * @param rscope
     * @return
     */
    private boolean checkScope(String[] rscope) {
        String scope = "";

        for (int i = 0; i < rscope.length; i++) {
            scope = scope + rscope[i];
        }

        // 简单模拟权限验证.
        return appMap.get("scope").replace(" ", "").contains(scope);
    }


    /**
     * 生成code值.
     *
     * @param appId
     * @param user
     * @return
     */
    private String generateCode(String appId, String user) {

        // 模拟code生成.
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            stringBuilder.append(random.nextInt(10));
        }

        String code = stringBuilder.toString();

        // 存储code至codeMap.
        codeMap.put(code, appId + "|" + user + "|" + System.currentTimeMillis());

        return code;
    }
}
