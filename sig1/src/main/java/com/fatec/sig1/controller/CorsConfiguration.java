package com.fatec.sig1.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
	Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	logger.info(">>>>>> configuracao do cors");
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000/")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}