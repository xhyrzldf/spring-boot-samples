package com.zjty.cxfwebservice.webservice;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 接口
 *
 * @author leftso
 */
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://spring.io/guides/gs-producing-web-service/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {
    @WebMethod
    @WebResult(name = "String")
    String sayHello(@WebParam(name = "userName") String name);
}
