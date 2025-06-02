package servicetwo.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import servicetwo.demo.config.ApplicationConfig;

@RestController
@RequestMapping("/api")
@RefreshScope
public class HelloController {

    @GetMapping("/hello")
    public String hello() throws UnknownHostException {
        return "Hello from: " + InetAddress.getLocalHost().getHostName();
    }
}
