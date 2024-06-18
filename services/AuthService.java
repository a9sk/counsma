public class AuthService {
    private UserService userService;
    private TokenService tokenService;

    public AuthService(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public String authenticate(String usernameOrEmail, String password) throws Exception {
        User user = userService.getUserByUsername(usernameOrEmail);
        if (user == null) {
            user = userService.getUserByEmail(usernameOrEmail);
        }

        if (user == null || !user.getHashedPassword().equals(hashPassword(password))) {
            throw new Exception("Invalid username/email or password.");
        }

        return tokenService.generateToken(user);
    }

    private String hashPassword(String password) {
        // Implement password hashing logic here
        return password; // Replace with actual hashing
    }
}
