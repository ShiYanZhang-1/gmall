package top.shiyana.gmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.gateway.config
 * @ClassName: WebCorsConfig
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/4 17:47
 * @Version: 1.0
 */
@Configuration
public class WebCorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){

            CorsConfiguration config = new CorsConfiguration();
            config.addAllowedMethod("*");
            config.addAllowedOrigin("*");
            config.addAllowedHeader("*");
            config.setAllowCredentials(true);

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);

            return new CorsWebFilter(source);
        }

        /*CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:1024");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }*/
}
