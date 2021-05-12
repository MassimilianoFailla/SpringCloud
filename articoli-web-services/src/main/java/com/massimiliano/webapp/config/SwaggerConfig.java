package com.massimiliano.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.massimiliano.webapp.controller"))
        .build()
        .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                .title("Articoli Web Services")
                .description("Spring boot REST API per la gestione degli articoli AlphaShop")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://apache.org/license/LICENSE-2.0")
                .contact(new Contact("Massimiliano Failla", "https://massimiliano.it/info", "madalinvalentin.failla@gmail.com"))
                .build();
    }

}
