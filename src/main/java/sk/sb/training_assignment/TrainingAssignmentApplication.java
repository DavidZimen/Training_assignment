package sk.sb.training_assignment;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import sk.sb.training_assignment.search.mapper.UserMapper;

import java.util.Arrays;

/**
 * Main class of the project.
 * @author <a href="https://github.com/DavidZimen">Dávic Zimen</a>
 */
@SpringBootApplication
public class TrainingAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingAssignmentApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfig.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Accept",
                "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers",
                "Authorization", "X-Requested-With", "Access-Control-Allow-Origin"));
        corsConfig.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    UserMapper getUserMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
}
