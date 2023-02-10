package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Empp {
    public static void main(String[] args) {
        Connection conn= null;
        Scanner sc= new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully!");
            conn= DriverManager.getConnection("jdbc:oracle:thin:@//Aman_Tiwari:1521/xe", "advjava","java");
            System.out.println("Connection opened successfully!");
            String choice;
            int count=0, tmp=0 ;
            do{
                PreparedStatement ps=conn.prepareStatement("insert into empp values(?,?,?,?)");
                System.out.print("Enter the employee number: ");
                int eno=sc.nextInt();
                System.out.print("Enter the employee name: ");
                sc.nextLine();
                String ename= sc.nextLine();
                System.out.print("Enter the employee salary: ");
                double sal= sc.nextDouble();
                System.out.print("Enter the employee deparment number(10/20/30/40): ");
                int depno= sc.nextInt();
                ps.setInt(1,eno);
                ps.setString(2,ename);
                ps.setDouble(3,sal);
                ps.setInt(4,depno);
                int ans=ps.executeUpdate();

                PreparedStatement pss=conn.prepareStatement("update expenses set amount = amount + ? where depno = ?");

//                System.out.print("Enter dept no.: ");
//                dept = sc.nextInt();
//                System.out.print("Enter the amount: ");
//                amt = sc.nextInt();

                pss.setDouble(1, sal);
                pss.setInt(2, depno);
                int temp = pss.executeUpdate();

                if (temp==1)
                    tmp++;

                if(ans==1)
                    count++;
                System.out.print("Do you want to continue adding employee(yes/no): ");
                choice= sc.next();

            }while (choice.equalsIgnoreCase("yes"));
            System.out.println(count +" Records entered in empp table successfully!");
            System.out.println(tmp +" Records entered in expenses table successfully!");

        }catch (ClassNotFoundException cnf){
            System.out.println("Driver class could not be loaded.."+ cnf.getMessage());
        }
        catch (SQLException s){
            System.out.println("Problem in db "+ s.getMessage());
        }
        finally{
            try{
                if(conn!=null){
                    conn.close();
                    System.out.println("Connection clossed successfully");
                }
            }catch (SQLException s){
                System.out.println("Problem in closing the connection. "+s.getMessage());
            }
        }
    }
}
