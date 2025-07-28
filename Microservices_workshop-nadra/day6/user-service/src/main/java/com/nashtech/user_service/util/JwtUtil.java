import java.util.Base64;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtUtil {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Object> extractClaims(String token) {
        String[] chunks = token.split("\\.");
        if (chunks.length < 2) {
            throw new IllegalArgumentException("Invalid JWT token");
        }

        String payload = chunks[1];
        byte[] decodedBytes = Base64.getUrlDecoder().decode(payload);
        try {
            return objectMapper.readValue(decodedBytes, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JWT claims", e);
        }
    }
}
