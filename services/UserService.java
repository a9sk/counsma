import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> usersByUsername = new HashMap<>();
    private Map<String, User> usersByEmail = new HashMap<>();

    public void registerUser(String username, String email, String password) throws Exception {
        if (usersByUsername.containsKey(username) || usersByEmail.containsKey(email)) {
            throw new Exception("User already exists.");
        }

        String hashedPassword = hashPassword(password);
        String id = generateUserId();
        User user = new User(id, username, email, hashedPassword);

        usersByUsername.put(username, user);
        usersByEmail.put(email, user);
    }

    public User getUserByUsername(String username) {
        return usersByUsername.get(username);
    }

    public User getUserByEmail(String email) {
        return usersByEmail.get(email);
    }

    private String hashPassword(String password) {
        // Implement password hashing logic here
        return password; // Replace with actual hashing
    }

    private String generateUserId() {
        // Implement unique user ID generation logic here
        return "unique-id"; // Replace with actual ID generation
    }
}
