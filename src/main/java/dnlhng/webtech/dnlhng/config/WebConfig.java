package dnlhng.webtech.dnlhng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Erlaubt CORS-Anfragen für alle Endpunkte von der Domain, auf der dein Vue.js-Client läuft
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:8080", "https://dnlhng-frontend.onrender.com");
    }
}