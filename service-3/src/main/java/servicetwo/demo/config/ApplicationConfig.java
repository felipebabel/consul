package servicetwo.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ApplicationConfig {

    @Value("${audience:default}")
    private String audience;

    public String getAudience() {
        return this.audience;
    }
}
