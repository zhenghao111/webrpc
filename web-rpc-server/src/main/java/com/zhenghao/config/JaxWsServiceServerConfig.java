package com.zhenghao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class JaxWsServiceServerConfig {

    // 不需要指定一个被导出的bean
    // 搜索Spring上下文查找所有@WebService注解的bean 发布为 JAX-WS端点
    @Bean
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
//        exporter.setBaseAddress("http://localhost:8080/service");
        return exporter;

    }
}
