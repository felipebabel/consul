package serviceone.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import serviceone.demo.controller.ServiceTreeClient;
import serviceone.demo.controller.ServiceTwoClient;

@Service
public class ServiceTreeService {

    private final ServiceTreeClient serviceTreeClient;

    public ServiceTreeService(ServiceTreeClient serviceTreeClient) {
        this.serviceTreeClient = serviceTreeClient;
    }

    @CircuitBreaker(name = "service-3", fallbackMethod = "fallback")
    @Retry(name = "service-3")
    @RateLimiter(name = "service-3")
    public String getHello() {
        return serviceTreeClient.getHello();
    }

    public String fallback(Throwable t) {
        System.out.println(">>> Fallback called! Service Tree is down.");
        return "Fallback: Service Tree is unavailable";
    }
}
