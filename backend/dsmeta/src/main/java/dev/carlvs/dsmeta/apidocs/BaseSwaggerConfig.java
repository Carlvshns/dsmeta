package dev.carlvs.dsmeta.apidocs;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class BaseSwaggerConfig {

    private final String basePackage;

    public BaseSwaggerConfig(String basePackage) {
        this.basePackage = basePackage;
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(basePackage))
        .build()
        .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder().title("Project Created in Week Spring React by DevSuperior")
        .description("API Java 11 with Spring Boot 2.6.4 to list sales details and notify")
        .version("1.0")
        .contact(new Contact("Carlos", "https://github.com/Carlvshns", "No email"))
        .license("Hobby Dev Project/Apache LICENSE 2.0")
        .licenseUrl("https://apache.org/licenses/LICENSE-2.0")
        .build();
    }
}

