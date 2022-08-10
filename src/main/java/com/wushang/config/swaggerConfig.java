//package com.wushang.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
//@Configuration
//@EnableSwagger2
//public class swaggerConfig {
//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //RequestHandlerselectors,配置要扫描接口的方式
//                //basePackage :指定要扫描的包
//                //any():扫描全部
//                //none():不扫描
//                //withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
//                //wi thMethodAnnotation:扫描方法上的注解
//                .apis(RequestHandlerSelectors.basePackage ("com.wushang.Servlet"))
//                //paths()。过滤什么路径
////                . paths (PathSelectors.ant("//**"))
//                .build()
//                //是否启动Swagger2
//                .enable(true)
//                ;
//    }
//    public ApiInfo apiInfo(){
//        Contact contact=new Contact("AcidRain","www.baidu.com","212156949@qq.com");
//        return new ApiInfo("人员信息管理的（swagger）Api文档",
//                "Good Good Study,Day Day Up",
//                "1.0",
//                "urn:tos",
//                contact,
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList());
//    }
//}
