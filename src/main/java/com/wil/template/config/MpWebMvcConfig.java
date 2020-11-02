package com.wil.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description webMvc 配置
 * @Author wil
 * @Date 2020/08/12 10:29:45
 * @Version 1.0
 */
@Configuration
public class MpWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOrigins("*").
                allowedMethods("DELETE", "GET", "POST", "OPTIONS", "PUT")
                .allowedHeaders("*")
                .allowCredentials(true).maxAge(3600);
    }

}
