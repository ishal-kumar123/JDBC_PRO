package org.example.Driver;

import org.example.Dao.Dbcon;
import org.example.Entity.Customer;
import java.util.Scanner;

    public class CustomerDriver {
        private static int choice = 0;
        private static Scanner sc = new Scanner(System.in);

        public static <Dbutil> void main(String[] args) {
            Dbcon db = new Dbcon();
            Dbcon.connecToDB();
            do {
                System.out.println("1.insert\n2.Delete\n3.Update\n4.DisplayAll\n5.GetByac_no");
                System.out.println("Enter your choice :");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        Customer c1 = new Customer();
                        System.out.println("Enter ac_no");
                        c1.setAc_no(sc.nextInt());
                        System.out.println("Enter name");
                        sc.nextLine();
                        c1.setName(sc.nextLine());
                        System.out.println("Enter branch");
                        c1.setBranch(sc.nextLine());
                        int rws = db.insert(c1);
                        if (rws > 0) {
                            System.out.println(c1.getName() + " Customer inserted successfully");
                        } else {
                            System.out.println("Issue in inserting");
                        }
                        break;
                    case 2:
                        System.out.println("Enter ac_no");
                        if (db.deleteByid(sc.nextInt())) {
                            System.out.println("Data Deleted");
                        } else {
                            System.out.println("issue in deleteing data");
                        }
                        break;
                    case 3:
                        Customer c2 = new Customer();
                        System.out.println("Enter the ac_no You want to UPDATE");
                        c2.setAc_no(sc.nextInt());
                        System.out.println("Enter name You want to Update");
                        sc.nextLine();
                        c2.setName(sc.nextLine());
                        System.out.println("Enter the Updated Branch name");
                        c2.setBranch(sc.nextLine());
                        if (db.update(c2) > 0) {
                            System.out.println("Updated.....");
                        } else {
                            System.out.println("issue in updating");
                        }
                        break;

                    case 4:
                        db.DisplayAll();
                        break;
                    case 5:
                        System.out.println("Enter ac_no");
                        db.getByid(sc.nextInt());
                    default:
                        System.out.println("Enter valid data");
                }

            } while (choice != 0);


        }}
