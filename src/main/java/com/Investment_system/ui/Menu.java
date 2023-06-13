package com.Investment_system.ui;

import com.Investment_system.model.User;
import com.Investment_system.util.ApplicationContext;
import com.Investment_system.util.SecurityContext;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int choice ;
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
                run();
        }

        System.out.println();
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
            Menu.editMenu();
        } else {
            System.out.println("Username or passwrod is wrong.");
            Menu.run();
        }


    }

    public static void signup() {
        String pass_pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        String email_pattern = "(?i)^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        User user = new User();
        System.out.println("enter your name :");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter your user_name :");
        String user_name = scanner.nextLine();
        System.out.println("enter your email :");
        String email = scanner.nextLine();
        System.out.println("enter your password :");
        String password = scanner.nextLine();
        user.setName(name);
        user.setUser_name(user_name);
        user.setEmail(email);
        user.setPassword(password);
        if (user.getEmail().matches(email_pattern) && user.getPassword().matches(pass_pattern)) {
            ApplicationContext.getUserService().add(user);
        }
        else {
            System.out.println("your email or password(use 8 char and upper and lower and symbol) not correct");
            signup();
        }
    }

    public static void editMenu() {
        System.out.println("ediiiiiiiiiii");
    }
}
