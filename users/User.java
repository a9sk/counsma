public class User {
    private String id;
    private String username;
    private String email;
    private String hashedPassword;

    public User(String id, String username, String email, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    // Getters and setters for all fields
}
