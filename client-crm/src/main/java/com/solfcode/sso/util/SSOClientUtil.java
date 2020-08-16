package com.solfcode.sso.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Administrator
 */
public class SSOClientUtil {

    private static Properties ssoProperties = new Properties();
    /**
     * 统一认证中心
     */
    public static String SERVER_URL_PREFIX;
    /**
     * 当前客户端地址
     */
    public static String CLIENT_HOST_URL;
    static {
        try {
            ssoProperties.load(SSOClientUtil.class.getClassLoader().getResourceAsStream("sso.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SERVER_URL_PREFIX = ssoProperties.getProperty("server-url-prefix");
        CLIENT_HOST_URL = ssoProperties.getProperty("client-host-url");
    }

    /**
     *
     * 根据request获取请求的地址
     *
     * @param request
     * @return
     */
    public static  String getRedirectUrl(HttpServletRequest request){

        return CLIENT_HOST_URL + request.getServletPath();
    }

    /**
     *
     * 根据request获取跳转到统一认证中心的地址
     *
     *   http://www.sso.com:8443/checkLogin?redirectUrl=http://www.crm.com:8088/main
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public static void redirectToSSOURL(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String redirectUrl = getRedirectUrl(request);
        StringBuilder url = new StringBuilder(50)
                .append(SERVER_URL_PREFIX)
                .append("/checkLogin?redirectUrl=")
                .append(redirectUrl);
        response.sendRedirect(url.toString());
    }
}
