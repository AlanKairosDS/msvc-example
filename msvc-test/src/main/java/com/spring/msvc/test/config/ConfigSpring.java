package com.spring.msvc.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.spring"})
public class ConfigSpring {

  @Bean
  WebMvcConfigurer corsConfigurer () {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
      }
    };
  }
}
