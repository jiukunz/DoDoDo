package com.thoughtworks.spring.jpa.tomcat.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by dwwang on 2/9/15.
 */
@WebService(serviceName="HelloService")
public class HelloWebService {
    @WebMethod
    public String sayHello(String firstName){
        return "hello" + firstName;
    }
}
