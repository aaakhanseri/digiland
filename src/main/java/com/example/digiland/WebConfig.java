package com.example.digiland;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // все эндпоинты
                        .allowedOrigins("*") // разрешить со всех доменов
                        .allowedMethods("*") // разрешить все методы (GET, POST, PUT, DELETE и т.д.)
                        .allowedHeaders("*"); // разрешить любые заголовки
            }
        };
    }
}
