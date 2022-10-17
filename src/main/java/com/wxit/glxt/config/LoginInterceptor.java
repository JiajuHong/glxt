package com.wxit.glxt.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    private List<String> url = new ArrayList();

    /**
     * 开始进入地址请求拦截
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute("currentuser") != null) {
            return true;
        } else {
            response.sendRedirect("/login"); // 未登录，跳转到登陆页面
            return false;
        }
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public List<String> getUrl() {
        url.add("/login"); // 登录页
        url.add("/gologin"); // 登录action URL
        url.add("/register");
        url.add("/goregister");

        // 网站静态资源
        url.add("/css/**");
        url.add("/js/**");
        url.add("/images/**");
        return url;
    }
}
