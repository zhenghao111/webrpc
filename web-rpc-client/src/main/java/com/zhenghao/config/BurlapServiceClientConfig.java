package com.zhenghao.config;


import com.caucho.burlap.client.BurlapProxyFactory;
import com.zhenghao.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;


//@Configuration
public class BurlapServiceClientConfig {

    @Bean
    public BurlapProxyFactoryBean burlapProxyFactoryBean() {
        BurlapProxyFactoryBean proxy = new BurlapProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/server/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }

}
