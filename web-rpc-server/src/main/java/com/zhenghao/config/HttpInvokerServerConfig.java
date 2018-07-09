package com.zhenghao.config;

import com.zhenghao.service.SpitterService;
import com.zhenghao.service.SpitterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class HttpInvokerServerConfig {

    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }

    // 将服务bean 导出为 HTTP Invoker服务
    // HttpInvokerServiceExporter是一个控制器
    // URL请求 -> DispatcherServlet -> httpInvokerServiceExporter bean -> 访问服务实现类
    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(SpitterService spitterService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }

    // httpInvokerServiceExporter是一个控制器，所以需要映射URL 到 服务器上
    @Bean
    public HandlerMapping httpInvokerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/spitter.service", "httpInvokerServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }
}
