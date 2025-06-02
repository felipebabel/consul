package servicetwo.demo.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Autowired
    ApplicationConfig applicationConfig;

    private static final String SECRET_KEY = "X9RgEAKOfTFc1Ww7vEvAXh+r8B4E6DrEdS6tZ2EiU1lE=";

    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token);

            String audience = claimsJws.getBody().getAudience();
            System.out.println("Audience: " + this.applicationConfig.getAudience());
            return this.applicationConfig.getAudience().equals(audience);
        } catch (JwtException e) {
            return false;
        }
    }
}