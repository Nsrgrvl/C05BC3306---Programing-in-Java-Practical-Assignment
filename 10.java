import java.sql.*;
import java.util.Scanner;

public class JDBCCRUDApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/collegedb";
        String user = "root";
        String pass = "password";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("1. Insert | 2. Display | 3. Update | 4. Delete");
            System.out.print("Choose operation: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    PreparedStatement pstIn = con.prepareStatement("INSERT INTO Student VALUES(?, ?, ?)");
                    System.out.print("Enter GRNo, Name, Marks: ");
                    pstIn.setInt(1, sc.nextInt());
                    pstIn.setString(2, sc.next());
                    pstIn.setInt(3, sc.nextInt());
                    System.out.println("Affected rows: " + pstIn.executeUpdate());
                    break;
                case 2:
                    PreparedStatement pstSel = con.prepareStatement("SELECT * FROM Student");
                    ResultSet rs = pstSel.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3));
                    }
                    break;
                case 3:
                    PreparedStatement pstUp = con.prepareStatement("UPDATE Student SET marks=? WHERE grno=?");
                    System.out.print("Enter New Marks and GRNo: ");
                    pstUp.setInt(1, sc.nextInt());
                    pstUp.setInt(2, sc.nextInt());
                    System.out.println("Affected rows: " + pstUp.executeUpdate());
                    break;
                case 4:
                    PreparedStatement pstDel = con.prepareStatement("DELETE FROM Student WHERE grno=?");
                    System.out.print("Enter GRNo to delete: ");
                    pstDel.setInt(1, sc.nextInt());
                    System.out.println("Affected rows: " + pstDel.executeUpdate());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}