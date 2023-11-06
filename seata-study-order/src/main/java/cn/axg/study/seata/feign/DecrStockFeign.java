package cn.axg.study.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "stock", path = "stockAt")
public interface DecrStockFeign {

    /**
     * 减库存
     *
     * @return
     */
    @GetMapping("/decr")
    public String decr();

}
