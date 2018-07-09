package com.zhenghao.config;

import com.zhenghao.service.SpitterService;
import com.zhenghao.service.SpitterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class HessianServiceServerConfig {

    // 注册服务bean
    @Bean(name = "spitterService")
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }

    // 注册的hessianServiceExporter bean是一个Spring MVC控制器，处理请求URL是*.service的
    // URL请求 -> DispatcherServlet -> hessianServiceExporter bean -> 访问服务实现类
    // 将服务bean 导出为 Hessian服务
    @Bean(name = "hessianServiceExporter")
    public HessianServiceExporter hessianServiceExporter(SpitterService spitterService) {
        HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
        hessianServiceExporter.setService(spitterService);
        hessianServiceExporter.setServiceInterface(SpitterService.class);
        return hessianServiceExporter;
    }

    // 配置URL映射，确保DispatcherServlet把请求转给服务bean
    @Bean
    public HandlerMapping hessianMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        // Application context设置为/server，Hessian服务地址http://localhost:8080/server/spitter.service
        mappings.setProperty("/spitter.service", "hessianServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }
}