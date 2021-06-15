package com.example.demo;

import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build() ;
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Student API Endpoints").description("API to interact with student database").version("V1.0").build() ; 
	}
}
