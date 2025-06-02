package serviceone.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import serviceone.demo.service.ServiceTreeService;
import serviceone.demo.service.ServiceTwoService;

import org.springframework.http.ResponseEntity;

@RestController
public class TestController {

    private final ServiceTwoService serviceTwoService;

    private final ServiceTreeService serviceTreeService;


    public TestController(ServiceTwoService serviceTwoService, ServiceTreeService serviceTreeService) {
        this.serviceTwoService = serviceTwoService;
        this.serviceTreeService = serviceTreeService;
    }

    @GetMapping("/call-service-two")
    public String callServiceTwo() {
        return serviceTwoService.getHello();
    }

    @GetMapping("/call-service-tree")
    public ResponseEntity<String> callServiceTree() {
        String serviceTree = serviceTreeService.getHello();
        return ResponseEntity.ok("Service C: " + serviceTree);
    }
}
