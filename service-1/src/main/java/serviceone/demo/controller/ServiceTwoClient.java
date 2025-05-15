package serviceone.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-2")
public interface ServiceTwoClient {

    @GetMapping("/api/hello")
    String getHello();

}