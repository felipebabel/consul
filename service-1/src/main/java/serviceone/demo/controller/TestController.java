package serviceone.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ServiceTwoClient client;

    public TestController(ServiceTwoClient client) {
        this.client = client;
    }

    @GetMapping("/call-two")
    public String callTwo() {
        return client.getHello();
    }
}
