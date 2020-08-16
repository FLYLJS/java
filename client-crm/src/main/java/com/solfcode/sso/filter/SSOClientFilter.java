package com.solfcode.sso.filter;

import com.solfcode.sso.util.HttpUtil;
import com.solfcode.sso.util.SSOClientUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class SSOClientFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        //判断是否有局部回话
        HttpSession session = req.getSession();
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        if(isLogin != null && isLogin){
            //有局部回话
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //判断地址栏是否有携带token
        String  token = req.getParameter("token");
        if (StringUtils.isNotBlank(token)){
            //判断token由统一认证中心产生的
            String httpURL = SSOClientUtil.SERVER_URL_PREFIX+"/verify";
            /*HashMap<String, String> map = new HashMap<>();
            map.put("token",token);
            HttpUtil.sendHttpRequest(httpURL,map.get("token"));*/
            String verify = HttpUtil.sendHttpRequest(httpURL, token);
            if(StringUtils.isNotBlank(verify) && "true".equals(verify)){
                session.setAttribute("isLogin",true);
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        //没有局部回话，重定向到统一认证中心，看是否有其他系统登录
        //   http://www.sso.com:8443/checkLogin?redirectUrl=http://www.crm.com:8088
        SSOClientUtil.redirectToSSOURL(req,resp);
    }

    @Override
    public void destroy() {

    }
}
