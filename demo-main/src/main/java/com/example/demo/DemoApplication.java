package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class DemoApplication {

    public   static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Разрешает CORS для всех эндпоинтов
                        .allowedOrigins("*") // Разрешает любые источники
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешает определенные HTTP методы
                        .allowCredentials(true);
            }
        };
    }
}


