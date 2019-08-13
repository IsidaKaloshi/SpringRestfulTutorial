package com.SpringBasicRest.BasicRest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.lang.String;


/*
  Swagger is a popular documentation format for Restfull Services
  for Swagger I only included tow dependencies
  I can see the Rest Services in
  http://localhost:8080/swagger-ui.html#/

  or
  http://localhost:8080/v2/api-docs

  Documentation of API is very important I should do some exersizes
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    public static final Contact DEFAULT_CONTACT =
            new Contact("Ida Kaloshi", "www.localhost:8080", "isda_kaloshi@hotmail.com");

    public static final ApiInfo DEFAULT_API_INFO= new ApiInfo("My First Api Documentation", "Api Documentation of the User Services", "1.0", "urn:tos",
            DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =

            new HashSet<String>(Arrays.asList("application/json","application/xml")) ;


    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);

    }

}
