package com.wilson.demo.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger多源配置
 * <li>目标：保证启动后swagger-ui.html能展示来自不同类型的文档</li>
 * <li>使用方式：配置后自动生效，一定要配置允许跨域</li>
 * <li>现有bug：无</li>
 * @author Wilson 2020/02/06
 * @version 0.0.1
 * @since 0.0.1
 * @see SwaggerResource
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    /**
     * Swagger多源，体现在swagger-ui可列表选择不同swagger文档
     * @param defaultResourcesProvider
     * @return swagger资源生产者
     */
    @Bean
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            List<SwaggerResource> resourcesList = new ArrayList<>();

            // 静态文件，存于resources文件夹下
            SwaggerResource resource1 = new SwaggerResource();
            resource1.setName("静态YML");
            resource1.setSwaggerVersion("2.0");
            resource1.setLocation("/swagger-api.yml");
            resourcesList.add(resource1);

            // 模拟数据库获取拼接的文档，请求见SwaggerController
            SwaggerResource resource2 = new SwaggerResource();
            resource2.setName("动态API");
            resource2.setSwaggerVersion("2.0");
            resource2.setLocation("/json");
            resourcesList.add(resource2);

            // 自身代码扫描生成的文档，默认路径http://localhost:8080/v2/api-docs
            SwaggerResource resource3 = new SwaggerResource();
            resource3.setName("自身");
            resource3.setSwaggerVersion("2.0");
            resource3.setLocation("/v2/api-docs");
            resourcesList.add(resource3);
            return resourcesList;
        };
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wilson.demo.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restful风格")
                .version("0.1")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/","classpath:/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
