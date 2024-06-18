import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {
    private Map<String, User> usersByUsername = new HashMap<>();
    private Map<String, User> usersByEmail = new HashMap<>();

    public void registerUser(String username, String email, String password) throws Exception {
        if (usersByUsername.containsKey(username) || usersByEmail.containsKey(email)) {
            throw new Exception("User already exists.");
        }
        byte[] salt = HashService.generateSalt();
        String hashedPassword = HashService.hashPassword(password, salt);
        UUID id = generateUserId();
        User user = new User(id, username, email, hashedPassword, salt);

        usersByUsername.put(username, user);
        usersByEmail.put(email, user);
    }

    public User getUserByUsername(String username) {
        return usersByUsername.get(username);
    }

    public User getUserByEmail(String email) {
        return usersByEmail.get(email);
    }
    
    private UUID generateUserId() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
}
