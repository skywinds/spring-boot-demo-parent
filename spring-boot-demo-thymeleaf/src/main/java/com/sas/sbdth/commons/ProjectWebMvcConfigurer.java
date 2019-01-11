package com.sas.sbdth.commons;

import com.sas.sbdth.interceptor.ParameterInitializeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    ParameterInitializeInterceptor parameterInitializeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(parameterInitializeInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index");
    }
}
