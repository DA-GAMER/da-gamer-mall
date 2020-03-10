package com.dagamer.mall.seckill.interceptor;

import com.dagamer.mall.seckill.service.consumer.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("TOKEN");
        System.out.println(token);
        if (!StringUtils.isBlank(token)) {
            // 判断session下有没有存在已登录用户
            HttpSession session = request.getSession();
            if (StringUtils.isNotBlank((String) session.getAttribute("TOKEN"))) {
                return true;
            }
            // 查看用户是否登录
            String userJson = redisService.get(token);
            System.out.println(userJson);
            if (StringUtils.isNotBlank(userJson)) {
                // 用户已经登录
                session.setAttribute("TOKEN", userJson);
                return true;
            }
        }
        response.getWriter().write("no login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

}
