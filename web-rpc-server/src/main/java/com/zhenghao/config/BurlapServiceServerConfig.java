package com.zhenghao.config;

import com.zhenghao.service.SpitterService;
import com.zhenghao.service.SpitterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

//@Configuration
public class BurlapServiceServerConfig {

    // 注册服务bean
    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }

    // 将服务bean 导出为 Burlap服务
    @Bean
    public BurlapServiceExporter burlapServiceExporter(SpitterService spitterService) {
        BurlapServiceExporter burlapServiceExporter = new BurlapServiceExporter();
        burlapServiceExporter.setService(spitterService);
        burlapServiceExporter.setServiceInterface(SpitterService.class);
        return burlapServiceExporter;
    }

    // 配置URL映射，确保DispatcherServlet把请求转给服务bean
    @Bean
    public HandlerMapping hessianMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        // Application context设置为/server，Burlap服务地址http://localhost:8080/server/spitter.service
        mappings.setProperty("/spitter.service", "burlapServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }
}
