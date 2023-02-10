package jdbc;

import java.sql.*;
import java.util.Scanner;

public class ManuAllBooks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava", "java");
            System.out.println("Connection opened successfully!");
            Statement st;
            ResultSet rs;
            PreparedStatement ps;
            String choice;
            int ans, count = 0, choose;


            do {
                System.out.println("Here, we go in allbooks table....what do you want to do??");
                System.out.println("1. Show table data");
                System.out.println("2. Insert new data");
                System.out.println("3. Delete any data");

                System.out.print("Please your choice: ");
                choose = in.nextInt();
                switch (choose) {
                    case 1:
                        st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        rs = st.executeQuery("select serial_no, name, subject, price from allbooks");
                        System.out.println("Serial_no" + "\t" + " Name" + "\t" + " Subject" + "\t" + "Price");
                        while (rs.next()) {
                            int serial_no = rs.getInt(1);
                            String name = rs.getString(2);
                            String sub = rs.getString(3);
                            int price = rs.getInt(4);
                            System.out.println(serial_no + "\t" + name + "\t" + sub + "\t" + price);
                        }
                        break;

                    case 2:
                        ps = conn.prepareStatement("insert into allbooks values(?, ?, ?, ?)");

                        System.out.print("Enter serial_no: ");
                        int serial_no = in.nextInt();
                        System.out.print("Enter BookName: ");
                        in.nextLine();
                        String BookName = in.nextLine();
                        System.out.print("Enter Subject of book: ");
                        String sub = in.nextLine();
                        System.out.print("Enter price of book: ");
                        double price = in.nextDouble();

                        ps.setInt(1, serial_no);
                        ps.setString(2, BookName);
                        ps.setString(3, sub);
                        ps.setDouble(4, price);

                        ans = ps.executeUpdate();
                        if (ans==1)
                            ++count;
                        System.out.println("Record inserted: " + count);
                        break;

                    case 3:
                        st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rs = st.executeQuery("select serial_no from allbooks");

                        System.out.println("Which book do you want to delete??");
                        System.out.print("Enter the serial_no: ");
                        serial_no = in.nextInt();

                        int deleteRow = serial_no % 100;

                        rs.absolute(deleteRow);
                        rs.deleteRow();
                        break;

                    default:
                        System.out.println("Wrong input....!");
                        break;
                }
                System.out.print("Do you want to continue(yes/no)? ");
                choice = in.next();
            }while (choice.equalsIgnoreCase("yes"));

        }catch (ClassNotFoundException ex) {
            System.out.println("Cannot loaded driver class: " + ex.getMessage());
        }catch (SQLException ex) {
            System.out.println("Problem in db: " + ex.getMessage());
        }finally {
            try {
                if (conn!=null) {
                    conn.close();
                    System.out.println("Connection closed successfully!");
                }
            }catch (SQLException ex) {
                System.out.println("Problem in closing connection: " + ex.getMessage());
            }
            System.out.println("Thank you for using...!!");
        }
    }
}
