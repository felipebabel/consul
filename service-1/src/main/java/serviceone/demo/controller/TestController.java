package serviceone.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import serviceone.demo.service.HelloService;

@RestController
public class TestController {

    private final HelloService helloService;

    public TestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/call")
    public String call() {
        return helloService.getHello();
    }
}
