package org.example.proxy.common.config.knife4j;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

/**
 * @Author Marshall
 * @Date 2025/2/12 16:19
 * @Description:
 */
public class Knife4jConfig {
    @Bean
    public GroupedOpenApi webApi() {
        return GroupedOpenApi.builder()
                .group("web-api")
                .pathsToMatch("/**")
                .build();
    }

//    @Bean
//    public GroupedOpenApi adminApi() {
//        return GroupedOpenApi.builder()
//                .group("admin-api")
//                .pathsToMatch("/admin/**")
//                .build();
//    }

    /***
     * @description 自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Proxy-driver API Interface Documentation")
                        .version("1.0")
                        .description("Proxy-driver API Interface Documentation")
                        .contact(new Contact().name("qy")));
    }

}
