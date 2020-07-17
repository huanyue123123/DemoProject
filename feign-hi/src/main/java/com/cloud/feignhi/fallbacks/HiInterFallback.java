package com.cloud.feignhi.fallbacks;

import com.cloud.feignhi.inters.HiFeignInterface;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HiInterFallback implements HiFeignInterface {

    @Override
    public String sayHiToName(@PathVariable("name") String name) {
        return "===出错啦===->" + name;
    }
}
