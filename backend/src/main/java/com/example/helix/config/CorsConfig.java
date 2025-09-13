//package com.example.helix.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // Allow everything in development (all localhost ports)
//        registry.addMapping("/**")
//                .allowedOrigins(
//                        "http://localhost:4200",
//                        "http://127.0.0.1:4200",
//                        "http://localhost:3000",
//                        "http://127.0.0.1:3000",
//                        "http://localhost:8080",
//                        "http://127.0.0.1:8080",
//                        "http://localhost:5173",
//                        "http://127.0.0.1:5173",
//                        "http://localhost:51542",   // Flutter web random port
//                        "http://127.0.0.1:51542"
//                )
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//
//        // ⚠️ Development fallback: allow all localhost ports
//        registry.addMapping("/**")
//                .allowedOrigins("*")  // allows all origins
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(false) // must be false if using "*"
//                .maxAge(3600);
//    }
//}


package com.example.helix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")   // allow all origins
                .allowedMethods("*")   // allow all HTTP methods
                .allowedHeaders("*");  // allow all headers
    }
}
