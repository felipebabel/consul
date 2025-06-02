package serviceone.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import serviceone.demo.config.FeignJwtConfig;


@FeignClient(name = "service-3", configuration = FeignJwtConfig.class)
public interface ServiceTreeClient {

    @GetMapping("/api/hello")
    String getHello();

}