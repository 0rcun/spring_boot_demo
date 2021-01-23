package com.hkarabakla.spring_boot_demo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.Instant;

@Component
public class ResponseTimeLogger implements HandlerInterceptor {

    private static ThreadLocal<Instant> instant = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(Thread.currentThread().getName() + " : Request arrived for : " + request.getRequestURI());
        instant.set(Instant.now());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(Thread.currentThread().getName() + " : Request processed for : " + request.getRequestURI()
                + " at " + Duration.between(instant.get(), Instant.now()).getSeconds() + " seconds");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(Thread.currentThread().getName() + " : Response/View rendered for : " + request.getRequestURI()
                + " at " + Duration.between(instant.get(), Instant.now()).getSeconds() + " seconds");
        instant.remove();
    }
}
