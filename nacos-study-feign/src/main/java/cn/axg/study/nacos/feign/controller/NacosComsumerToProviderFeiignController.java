package cn.axg.study.nacos.feign.controller;

import cn.axg.study.nacos.feign.service.NacosConsumerToProviderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosComsumerToProviderFeiignController {

    @Autowired
    private NacosConsumerToProviderFeignService nacosConsumerToProviderFeignService;

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable("message") String message){
        String doscovery = nacosConsumerToProviderFeignService.doscovery(message);
        return "成功访问了discover提供的方法======>"+doscovery;
    }


}
