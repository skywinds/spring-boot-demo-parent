package com.sas.sbdth.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    ParameterInitializeInterceptor parameterInitializeInterceptor;

    /**
     * 注意，如果不设置首页(template/index.html)，系统会导向到/error页面，这样，就会造成排除的路径不生效(依然走到拦截器)的假象；
     *
     * 可在拦截器中输出请求路径，即可知晓！～
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(parameterInitializeInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html");
    }

    /**
     * 设置首页
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
}
