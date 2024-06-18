import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String email;
    private String hashedPassword;
    private byte[] salt;

    public User(UUID id, String username, String email, String hashedPassword, byte[] salt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    
    public byte[] getSalt() {
        return salt;
    }
    
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
