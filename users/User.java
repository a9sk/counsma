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

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
