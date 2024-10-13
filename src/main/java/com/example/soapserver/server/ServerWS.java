package com.example.soapserver.server;

import com.example.soapserver.webservice.ProductWebService;
import jakarta.xml.ws.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.soapserver.repository")
public class ServerWS {
    public static void main(String[] args){
        String url="http://localhost:8088/"; //hoooooooow
        Endpoint.publish(url, new ProductWebService());
        System.out.println(url + "  deployed");

    }
}
