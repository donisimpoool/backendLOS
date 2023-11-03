package com.ikkat.los;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ikkat.los.utils.SchemaSql;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableConfigurationProperties({ FileStorageProperties.class })
@EnableSwagger2
public class LosEngineApps1Application extends SpringBootServletInitializer {
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LosEngineApps1Application.class);
    }
	
	public static void main(String[] args) {
//		SchemaSql.ExecuteAlterSql();
		SpringApplication.run(LosEngineApps1Application.class, args);
	}
	
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	        	 registry.addMapping("/*").allowedOrigins("/*");
	         }
	      };
	   }
	
	

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ikkat.los.controller")).build();
	}
	
//	@Configuration
//	@Order(Ordered.HIGHEST_PRECEDENCE)
//	class SecurityConfig extends WebSecurityConfigurerAdapter {
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
////	        http.csrf().disable();
//	        http.cors();
//	    }
//	    @Bean
//	    public CorsConfigurationSource corsConfigurationSource() {
//	        final CorsConfiguration configuration = new CorsConfiguration();
//	        configuration.setAllowedOrigins(ImmutableList.of("*"));
//	        configuration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
//	        configuration.setAllowCredentials(true);
//	        configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
//	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", configuration);
//	        return source;
//	    }
//	}

}

