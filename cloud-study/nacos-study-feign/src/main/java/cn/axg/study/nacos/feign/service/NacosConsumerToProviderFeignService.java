package cn.axg.study.nacos.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nacos-provider")
public interface NacosConsumerToProviderFeignService {

    @GetMapping("/echo/{message}")
    public String doscovery(@PathVariable("message") String message);
}
