package com.zhenghao.config;

import com.zhenghao.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

//@Configuration
public class RmiServiceClientConfig {
    // 为RMI服务生成RMI代理，负责客户端与服务端通信的处理
    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        proxy.setServiceUrl("rmi://localhost/SpitterService");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }

}
