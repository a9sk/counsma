import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenService {
    private Map<String, User> tokenStore = new HashMap<>();

    public String generateToken(User user) {
        String token = UUID.randomUUID().toString();
        tokenStore.put(token, user);
        return token;
    }

    public User validateToken(String token) throws Exception {
        User user = tokenStore.get(token);
        if (user == null) {
            throw new Exception("Invalid token.");
        }
        return user;
    }
}
