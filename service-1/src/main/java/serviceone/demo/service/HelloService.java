package serviceone.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.stereotype.Service;

import serviceone.demo.controller.ServiceTwoClient;

@Service
public class HelloService {

    private final ServiceTwoClient serviceTwoClient;

    public HelloService(ServiceTwoClient serviceTwoClient) {
        this.serviceTwoClient = serviceTwoClient;
    }

    @CircuitBreaker(name = "service-2", fallbackMethod = "fallback")
    @Retry(name = "service-2")
    @RateLimiter(name = "service-2")
    public String getHello() {
        return serviceTwoClient.getHello();
    }

    public String fallback(Throwable t) {
        System.out.println(">>> Fallback called! Service Two is down.");
        return "Fallback: Service Two is unavailable";
    }
}
