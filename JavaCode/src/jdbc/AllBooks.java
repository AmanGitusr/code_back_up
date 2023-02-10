package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AllBooks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection opened successfully!");
            String choice;
            int count = 0;
            do {
                PreparedStatement ps = conn.prepareStatement("insert into allbooks values(?,?,?,?)");

                System.out.print("Enter book no.: ");
                int bno = in.nextInt();
                System.out.print("Enter book name: ");
                in.nextLine();
                String bname = in.nextLine();
                System.out.print("Enter price of the book: ");
                float bprice = in.nextFloat();
                System.out.print("Enter subject of the book: ");
                in.nextLine();
                String bsub = in.nextLine();

                ps.setInt(1, bno);
                ps.setString(2, bname);
                ps.setString(3, bsub);
                ps.setFloat(4, bprice);

                int ans = ps.executeUpdate();
                if (ans==1)
                    count++;
                System.out.print("Do you want to continue (yes/no): ");
                choice = in.next();

            }while (choice.equalsIgnoreCase("yes"));
            System.out.println("Record insert: " + count);
        } catch (SQLException e) {
            System.out.println("Problem in db: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot the driver class: " + e.getMessage());
        }finally {
            try {
                if (conn!=null) {
                    conn.close();
                    System.out.println("Connection close successfully!");
                }
            }catch (SQLException e) {
                System.out.println("Problem in closing connection: " + e.getMessage());
            }
        }
    }
}
