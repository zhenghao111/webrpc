package com.zhenghao.config;

import com.zhenghao.service.SpitterService;
import com.zhenghao.service.SpitterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;

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
}
