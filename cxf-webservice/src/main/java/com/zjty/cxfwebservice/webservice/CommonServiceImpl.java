package com.zjty.cxfwebservice.webservice;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * springboot-samples.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-17
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://spring.io/guides/gs-producing-web-service/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.zjty.cxfwebservice.webservice.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public String sayHello(String name) {
        return "Hello ," + name;
    }
}