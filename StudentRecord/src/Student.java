import java.sql.*;
import java.util.Scanner;

public class Student
{
public static void main(String[] args) {
   int i =1;
    Scanner sc = new Scanner(System.in);
    try
    {
        String host = "jdbc:mysql://localhost:3306/student";
        String uName = "root";
        String uPass = "password";
        Connection con = DriverManager.getConnection(host, uName, uPass);

        Statement stat = con.createStatement();
        while(i!=0) {
            String name,sql;
            int age,rno;
            int s;
            System.out.println("Select what operation you want to perform on the table: 1)Display 2)Insert 3)Delete 4)Update");
            s = sc.nextInt();
            if (s > 4 || s < 1) {
                System.out.println("ERROR");
                System.exit(0);
            }
            switch (s) {
                case 1:
                    sql = "select * from stud_info;";
                    ResultSet rs = stat.executeQuery(sql);
                    while(rs.next())
                    {
                        name = rs.getString("Name");
                        age = rs.getInt("Age");
                        rno = rs.getInt("Rno");
                        String p = name + "  " + age + "  " + rno + "  ";
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.println("Enter Student Details:");
                    System.out.println("Enter Name of Student:");
                    name = sc.next();
                    System.out.println("Enter Age:");
                    age = sc.nextInt();
                    System.out.println("Enter Roll Number:");
                    rno = sc.nextInt();

                    sql = "insert into stud_info " + "values (" + "'" + name + "'," + age + "," + rno + ");";
                    stat.executeUpdate(sql);
                    break;
                case 3:
                    System.out.println("Enter roll number of student to delete record:");
                    rno = sc.nextInt();
                    sql = "delete from stud_info where Rno = " + rno + ";";
                    stat.executeUpdate(sql);
                    break;
                case 4:
                    int c=1,ch;
                    String nm;
                    while(c!=0)
                    {
                        System.out.println("What record do you want to update: 1)Age 2)Roll Number3)Go back to menu. To exit completely press 0.");
                        ch = sc.nextInt();
                        switch(ch)
                        {
                            case 0:
                                System.exit(0);
                            case 1:
                                System.out.println("Enter name of the student whose record you want to edit: ");
                                name = sc.next();
                                System.out.println("Enter new updated age: ");
                                age = sc.nextInt();
                                sql = "update stud_info "+"SET Age = "+age+" where Name = '"+name+"';";
                                stat.executeUpdate(sql);
                                System.out.println("AGE HAS BEEN UPDATED!");
                                break;
                            case 2:
                                System.out.println("Enter name of the student whose record you want to edit: ");
                                name = sc.next();
                                System.out.println("Enter new updated roll number: ");
                                rno = sc.nextInt();
                                sql = "update stud_info "+"SET Rno = "+rno+" where Name = '"+name+"';";
                                break;
                            case 3:
                                c=0;
                                break;
                            default:
                                System.out.println("Invalid Entry!");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid!");
                    break;
            }
            System.out.println("If you wish to end task press 0 else press any OTHER NUMBER.");
            i = sc.nextInt();
        }

    } catch(SQLException err)
    {
        System.out.println(err.getMessage());
    }
}
}
