package com.fruit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@MapperScan("com.fruit.mapper")
@EnableSwagger2
public class OrangeApplication {

    @Bean
    Sampler sampler() {
        return new AlwaysSampler();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }
        };
    }

    @Bean
    public Docket swaggerPlugin() {
        return new Docket(DocumentationType.SPRING_WEB).groupName("orange").
                genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).
                forCodeGeneration(false).pathMapping("/").select().build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Jesse.Han", "https://github.com/hanlei840405", "hanlei.840405@gmail.com");
        ApiInfo apiInfo = new ApiInfo("orange's api", "rest", "0.0.1-SNAPSHOT", "https://github.com/hanlei840405", contact, "index", "");
        return apiInfo;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrangeApplication.class, args);
    }
}
