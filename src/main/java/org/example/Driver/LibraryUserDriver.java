package org.example.Driver;

import org.example.Dao.Dblibrary;
import org.example.Entity.LibraryUser;

import java.util.Scanner;

public class LibraryUserDriver {
    private static int choice = 0;
    private static Scanner sc = new Scanner(System.in);

    public static <DButil> void main(String[] args) {
        Dblibrary db = new Dblibrary();
        Dblibrary.connecToDB();
        do {
            System.out.println("1.insert\n2.Delete\n3.Update\n4.DisplayAll\n5.GetByid\n6.exit");
            System.out.println("Enter your choice :");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    LibraryUser lb = new LibraryUser();
                    System.out.println("Enter user_id");
                    lb.setUser_id(sc.nextInt());
                    System.out.println("Enter user_name");
                    sc.nextLine();
                    lb.setUser_name(sc.nextLine());
                    System.out.println("Enter Book_name");
                    lb.setBook_name(sc.nextLine());
                    int rws = db.insert(lb);
                    if (rws > 0) {
                        System.out.println(lb.getUser_name() + " User inserted successfully");
                    } else {
                        System.out.println("Issue in inserting");
                    }
                    break;
                case 2:
                    System.out.println("Enter user_ID");
                    if (db.deleteByid(sc.nextInt())) {
                        System.out.println("Data Deleted");
                    } else {
                        System.out.println("issue in deleteing data");
                    }
                    break;
                case 3:
                    LibraryUser lb1 = new LibraryUser();
                    System.out.println("Enter the user_id You want to UPDATE");
                    lb1.setUser_id(sc.nextInt());
                    System.out.println("Enter user_name You want to Update");
                    sc.nextLine();
                    lb1.setUser_name(sc.nextLine());
                    System.out.println("Enter the Updated  Book_name");
                    lb1.setBook_name(sc.nextLine());
                    if (db.update(lb1) > 0) {
                        System.out.println("Updated.....");
                    } else {
                        System.out.println("issue in updating");
                    }
                    break;

                case 4:
                    db.DisplayAll();
                    break;
                case 5:
                    System.out.println("Enter user_id");
                    db.getByid(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Enter valid data");
            }

        } while (choice != 0);

    }
}