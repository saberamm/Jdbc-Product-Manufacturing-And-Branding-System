package com.Investment_system.ui;

import com.Investment_system.util.ApplicationContext;
import com.Investment_system.util.SecurityContext;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int choice;
        do {
            System.out.println("================");
            System.out.println("Options:");
            System.out.println("1. signing");
            System.out.println("2. signup");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    signing();

                case 2:
                    signup();

                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    public static void signing() {
        System.out.println("Enter username : ");
        String username = scanner.next();
        System.out.println("Enter password : ");
        String password = scanner.next();


        if (ApplicationContext.getUserService().userAuthentication(username, password).getUser_name() != null) {
            SecurityContext.user_name = username;
            SecurityContext.user_id = ApplicationContext.getUserService().userAuthentication(username, password).getUser_id();
            System.out.println("You have logged in!");
        } else {
            System.out.println("Username or passwrod is wrong.");
        }


    }

    public static void signup() {
    }
}
