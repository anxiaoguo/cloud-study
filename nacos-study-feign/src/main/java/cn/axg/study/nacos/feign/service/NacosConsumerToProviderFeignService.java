package cn.axg.study.nacos.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//参数1：去找哪个服务 参数2：该接口访问的前缀也就是写在类上的@RequestMapping("prefix")
@FeignClient(name = "nacos-provider",path = "prefix")
public interface NacosConsumerToProviderFeignService {

    @GetMapping("/echo/{message}")
    public String doscovery(@PathVariable("message") String message);
}
