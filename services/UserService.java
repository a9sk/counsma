import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> usersByUsername = new HashMap<>();
    private Map<String, User> usersByEmail = new HashMap<>();
    private HashService hashService = new HashService();

    public void registerUser(String username, String email, String password) throws Exception {
        if (usersByUsername.containsKey(username) || usersByEmail.containsKey(email)) {
            throw new Exception("User already exists.");
        }
        byte[] salt = hashService.generateSalt();
        String hashedPassword = hashService.hashPassword(password, salt);
        String id = generateUserId();
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
    
    private String generateUserId() {
        // Implement unique user ID generation logic here
        return "unique-id"; // Replace with actual ID generation
    }
}

