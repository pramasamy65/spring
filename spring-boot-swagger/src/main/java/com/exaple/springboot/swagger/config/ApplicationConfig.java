package com.exaple.springboot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.exaple.springboot.swagger.controllers"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Prakash Ramasamy", "https://github.com/pramasamy65", "prakashkec@gmail.com");
		return new ApiInfoBuilder().title("Sample Swagger Implementation")
				.description("This is Sample Swagger - Spring boot based Service").version("1.0.0")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(contact)
				.build();
	}
}
