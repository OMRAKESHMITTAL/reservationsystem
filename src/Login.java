import java.util.Scanner;

public class Login {
    private static final String VALID_USERNAME = "root";
    private static final String VALID_PASSWORD = "admin";

    public static boolean login(Scanner scanner) {
        System.out.println("Enter your login id: ");
        String loginId = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        if (loginId.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid login id or password!");
            return false;
        }
    }
}
