import java.util.Scanner;

public class v2Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UserService userService = new UserService();
        TokenService tokenService = new TokenService();
        AuthService authService = new AuthService(userService, tokenService);
        while (true) { 
            System.out.println("Insert username:");
            String username = input.nextLine();
            System.out.println("Insert email:");
            String email = input.nextLine();
            System.out.println("Insert password");
            String password = input.nextLine();
            try {    
                userService.registerUser(username, email, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                String token = authService.authenticate(username, password);
                System.out.println("Authenticated token: " + token);

                User user = tokenService.validateToken(token);
                System.out.println("Authenticated user: " + user.getUsername());
                
                System.out.println("User:" + user.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}        

