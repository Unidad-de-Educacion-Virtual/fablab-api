package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Value("${cors.allowed.origins}")
	private String allowedOrigins;

	@Value("${cors.allowed.methods}")
	private String allowedMethods;

	@Value("${cors.allowed.headers}")
	private String allowedHeaders;

	@Value("${cors.allow.credentials}")
	private boolean allowCredentials;

	@Value("${cors.max.age}")
	private long maxAge;

	@Override
	public void addCorsMappings(@NonNull CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns(allowedOrigins.split(","))
				.allowedMethods(allowedMethods.split(","))
				.allowedHeaders(allowedHeaders.split(","))
				.allowCredentials(allowCredentials)
				.maxAge(maxAge);
	}

}
