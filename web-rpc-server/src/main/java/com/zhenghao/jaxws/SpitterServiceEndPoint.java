package com.zhenghao.jaxws;

import com.zhenghao.domain.Spitter;
import com.zhenghao.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

// JAX-WS服务端点
@Component
// 默认的服务地址还是 http://localhost:8080/SpitterService
@WebService(serviceName = "SpitterService")
// 对象生命周期有JAX-WS管理，对象的属性需要注入Spring管理的bean，用继承支持类SpringBeanAutowiringSupport启用自动装配
// 如果对象生命周期是有Spring管理，也就是一个bean，可以直接用自动装配
public class SpitterServiceEndPoint {

    @Autowired
    private SpitterService spitterService;

    // 委托给SpitterService
    @WebMethod
    public void addSpitter(Spitter spitter) {
        spitterService.saveSpitter(spitter);
    }

    @WebMethod
    public List<Spitter> getAllSpitters() {
        return spitterService.getAllSpitters();
    }


}
