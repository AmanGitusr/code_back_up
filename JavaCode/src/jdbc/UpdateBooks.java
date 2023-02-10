package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateBooks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Book> BookList = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection opened succussfully!");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select serial_no, name from allbooks order by serial_no");
            System.out.println("Serial_no" + "\t"+ "Book's name");
            while (rs.next()) {
                int serial_no = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("\t" + serial_no + "\t\t" + name);
            }


            PreparedStatement ps = conn.prepareStatement("update allbooks set name = ? where serial_no = ?");
            String choice;
            int count = 0;
            do {
                System.out.print("Enter the serial_no: ");
                int serial_no = in.nextInt();
                System.out.print("Enter the book's name: ");
                in.nextLine();
                String name = in.nextLine();

                ps.setString(1, name);
                ps.setInt(2, serial_no);

                int ans = ps.executeUpdate();
                if (ans==1)
                    ++count;
                int k= serial_no%100;
               rs.absolute(k);
                Book b = new Book(rs.getInt(1), rs.getString(2));
                BookList.add(b);

                System.out.print("Do you want update other books (yes/no): ");
                choice = in.next();
            }while (choice.equalsIgnoreCase("yes"));
            System.out.println("Updated Record: " + count);

            for (Book book : BookList) {
                System.out.println(book);
            }


        }catch (ClassNotFoundException ex) {
            System.out.println("Cannot loaded driver class: " + ex.getMessage());
        }catch (SQLException ex) {
            System.out.println("Problem in db: " + ex.getMessage());
        }finally {
            try {
                if (conn!=null) {
                    conn.close();
                    System.out.println("Connection close successfully");
                }
            }catch (SQLException ex) {
                System.out.println("Problem in closing connection: " + ex.getMessage());
            }
        }

    }
}
