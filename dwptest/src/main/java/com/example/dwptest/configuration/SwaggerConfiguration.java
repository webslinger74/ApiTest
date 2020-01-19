package com.example.dwptest.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	
	
	Contact contact = new Contact(
			"Steven Webster",
			"https://github.com/webslinger74",
			"webster_steven@yahoo.co.uk"
			);
	
	List<VendorExtension> vendorExtensions = new ArrayList<>();
	
	ApiInfo apiInfo = new ApiInfo(
			"Restful Api Web service Documentation",
			"This page documents DWPtest restful endpoints",
			"1.0",
			"http://github.com/webslinger74",
			 contact,
			"Apache 2.0",
			"http://www.apache.org/licences/LICENCE-2.0",
			vendorExtensions);
					
	
	@Bean
	public Docket apiDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.dwptest"))
				.paths(PathSelectors.any())
				.build();
		
		return docket;
	}
}