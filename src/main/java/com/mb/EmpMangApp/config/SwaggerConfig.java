package com.mb.EmpMangApp.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public ApiInfo createApiInfo() {
		return new ApiInfoBuilder()
				.title("Employee Management App")
				.description("develop by mb.com")
				.version("1.0")
				.build();
	}
	
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Management app")
				.apiInfo(createApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.mb.EmpMangApp"))
				.paths(PathSelectors.any())
				.build();
	}
}
