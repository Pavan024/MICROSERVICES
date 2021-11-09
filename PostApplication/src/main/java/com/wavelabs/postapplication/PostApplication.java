package com.wavelabs.postapplication;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_12).select().paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.wavelabs")).build().apiInfo(apiDetails());

	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
		"Employee API",
		"Sample API for SWAGGER usage",
		"1.0",
		"Free to use",
		new springfox.documentation.service.Contact("pavan", "http://", "pavan@gmail.com"),
		"API License",
		"http://",
		Collections.emptyList());
		}
}
