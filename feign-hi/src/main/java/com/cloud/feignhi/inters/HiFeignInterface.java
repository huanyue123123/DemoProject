package com.cloud.feignhi.inters;

import com.cloud.feignhi.fallbacks.HiInterFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eureka-client-hi",fallback = HiInterFallback.class)
public interface HiFeignInterface {

    @GetMapping("/hi/sayHiToName/{name}")
    String sayHiToName(@PathVariable("name") String name);
}
