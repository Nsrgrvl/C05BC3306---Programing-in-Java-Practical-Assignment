import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCInsertDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/collegedb";
        String user = "root";
        String pass = "password";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Scanner sc = new Scanner(System.in)) {

            String query = "INSERT INTO Student (grno, name, marks) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            System.out.print("Enter GR No: ");
            pstmt.setInt(1, sc.nextInt());
            sc.nextLine(); 
            System.out.print("Enter Name: ");
            pstmt.setString(2, sc.nextLine());
            System.out.print("Enter Marks: ");
            pstmt.setInt(3, sc.nextInt());

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record(s) inserted successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}