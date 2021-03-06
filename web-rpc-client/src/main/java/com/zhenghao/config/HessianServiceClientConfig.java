package com.zhenghao.config;


import com.zhenghao.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;


//@Configuration
public class HessianServiceClientConfig {

    @Bean
    public HessianProxyFactoryBean hessianProxyFactoryBean() {
        HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/server/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }

}
