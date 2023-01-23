package com.example.websevicedemo.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(info = @Info(
        title = "api 명세서",
        description = "api ",
        version = "v1"
))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {


//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public GroupedOpenApi projectApi() {
        String [] paths = {"/api/v1/**"};

        return GroupedOpenApi
                .builder()
                .group("rest api")
                .pathsToMatch(paths)
                .build();
    }

}
