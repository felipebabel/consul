package servicetwo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import servicetwo.demo.config.ApplicationConfig;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ApiKeyController {

    @Autowired
    ApplicationConfig applicationConfig;

    @GetMapping("/consul-value")
    public String getConsulValue() {
        return this.applicationConfig.getMessage();
    }
}
