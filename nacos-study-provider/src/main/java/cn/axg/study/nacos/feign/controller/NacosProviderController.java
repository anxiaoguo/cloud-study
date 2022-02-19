package cn.axg.study.nacos.feign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prefix")
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/echo/{message}")
    public String doscovery(@PathVariable("message") String message){
        return "Hello Nacos" + message + "i am from "+ port;
    }

}
