package com.learning.appliancestore.config;

import com.learning.appliancestore.interceptors.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by ivanov on 14.4.2018 г..
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final LogInterceptor logInterceptor;
    @Autowired
    public WebMvcConfig(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.logInterceptor);
    }

}

