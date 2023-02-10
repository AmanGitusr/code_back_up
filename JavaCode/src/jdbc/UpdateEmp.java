package jdbc;

import java.sql.*;
import java.util.Scanner;

public class UpdateEmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection opened successfully");
            PreparedStatement ps = conn.prepareStatement("update emp set name = ? where id = ?");
            System.out.print("Enter emp id: ");
            int id = sc.nextInt();
            System.out.print("Enter emp name: ");
            sc.nextLine();
            String name = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, id);

            int ans = ps.executeUpdate();
            System.out.println("Record inserted: " + ans);
        }catch (ClassNotFoundException cnf) {
            System.out.println("Cannot load the driver: " + cnf.getMessage());
        }catch (SQLException ex) {
            System.out.println("Problem in db: " + ex.getMessage());
        }finally {
            try {
                if (conn!=null) {
                    conn.close();
                    System.out.println("Connection close successfully!");
                }
            }catch (SQLException ex) {
                System.out.println("Problem in closing db: " + ex.getMessage());
            }
        }
    }
}
