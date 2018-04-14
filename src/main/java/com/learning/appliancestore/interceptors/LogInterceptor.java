package com.learning.appliancestore.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ivanov on 14.4.2018 г..
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LogManager.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) {
        req.setAttribute("preHandleTime", System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object o, ModelAndView mav) {
        req.setAttribute("postHandleTime", System.currentTimeMillis());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        Long preHandleTime = (Long)request.getAttribute("preHandleTime");
        Long postHandleTime = (Long) request.getAttribute("postHandleTime");
        long actionTime = postHandleTime - preHandleTime;
        long overallTime = System.currentTimeMillis() - preHandleTime;

        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;

        String message = String.format("[%s - %s] Action Execute Time: %d ms, Overall Execute Time: %d ms", handlerMethod.getBean().getClass(),
                handlerMethod.getMethod().getName(),
               actionTime, overallTime);

        LOGGER.info(message);
        }

    }

}
