import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginApp {
 public static void main(String[] args) throws Exception {
 Scanner input = new Scanner(System.in);

 System.out.print("Enter username: ");
 String username = input.nextLine();

 System.out.print("Enter password: ");
 String password = input.nextLine();

 Connection conn = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/users",
 "admin",
 "admin123"
 );

 String query = "SELECT * FROM accounts WHERE username=? AND password=?";
 PreparedStatement stmt = conn.prepareStatement(query);
 stmt.setString(1, username);
 stmt.setString(2, password);

 ResultSet results = stmt.executeQuery();

 if (results.next()) {
 System.out.println("Login successful!");
 } else {
 System.out.println("Login failed!");
 }

 results.close();
 stmt.close();
 conn.close();
 input.close();
 }
}
