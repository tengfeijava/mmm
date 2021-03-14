	package com;

import com.example.utils.JWTUtils;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import javax.servlet.MultipartConfigElement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.unit.DataSize;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import javax.servlet.MultipartConfigElement;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class JavaInformationplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaInformationplatformApplication.class, args);
    }

    @Bean
    public JWTUtils getJWTUtils(){
        return new JWTUtils();
    }



    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大 5m 可以使用读取配置
        factory.setMaxFileSize(DataSize.ofBytes(5242880));
       // factory.setMaxFileSize("5120MB"); //KB,MB
        /// 设置总上传数据总大小 50m
       // factory.setMaxRequestSize("512000MB");
        factory.setMaxRequestSize(DataSize.ofBytes(5242880));
        return factory.createMultipartConfig();
    }


//    @Configuration
//    public class TomcatConfig {
//        @Bean
//        public TomcatServletWebServerFactory webServerFactory() {
//            TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//            factory.addConnectorCustomizers((Connector connector) -> {
//                connector.setProperty("relaxedPathChars", "\"<>[\\]^`{|}");
//                connector.setProperty("relaxedQueryChars", "\"<>[\\]^`{|}");
//            });
//            return factory;
//        }
//    }
}

