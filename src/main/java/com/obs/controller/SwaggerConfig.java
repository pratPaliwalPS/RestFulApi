package com.obs.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		/*return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
				*/
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.obs.controller"))
				.paths(regex("/accrual.*")).build();
	}

	/*private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
	}*/

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Prashant API")
				.description("Prashant API reference for developers")
				.termsOfServiceUrl("http://chakdecoldfusion.blogspot.com")
				.contact("prashantgenial@gmail.com").license("Prashant License")
				.licenseUrl("prashantgenial@gmail.com").version("1.0").build();
	}

}
