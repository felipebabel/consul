package servicetwo.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ApplicationConfig {

    @Value("${message:default}")
    private String message;

    @Value("${audience:default}")
    private String audience;

    public String getMessage() {
        return this.message;
    }

    public String getAudience() {
        return this.audience;
    }
}
