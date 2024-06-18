public class Main {
    public static void main(String[] args) {
        try {
            UserService userService = new UserService();
            TokenService tokenService = new TokenService();
            AuthService authService = new AuthService(userService, tokenService);

            // Register a user
            userService.registerUser("a9sk", "920a9sk42f76c765@proton.me", "Password123?");

            // Authenticate the user
            String token = authService.authenticate("a9sk", "Password123?");
            System.out.println("Authenticated token: " + token);

            // Validate the token
            User user = tokenService.validateToken(token);
            System.out.println("Authenticated user: " + user.getUsername());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
