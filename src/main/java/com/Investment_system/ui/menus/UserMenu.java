package com.Investment_system.ui.menus;

import com.Investment_system.model.User;
import com.Investment_system.ui.color.ConsoleColor;
import com.Investment_system.util.ApplicationContext;
import com.Investment_system.util.SecurityContext;

import java.util.Scanner;

public class UserMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void UserRun() {
        int choice;
        System.out.println(ConsoleColor.BLUE_BOLD_BRIGHT+"========="+ConsoleColor.RESET+
                ConsoleColor.RED_BOLD_BRIGHT+"========="+ConsoleColor.RESET+
                ConsoleColor.YELLOW_BOLD+"========="+ConsoleColor.RESET+
                ConsoleColor.PURPLE_BOLD+"========="+ConsoleColor.RESET);
        System.out.println(ConsoleColor.YELLOW_BOLD_BRIGHT+"hi , welcome :))");
        System.out.println("Options:"+ConsoleColor.RESET);
        System.out.println(ConsoleColor.GREEN+"1. signing"+ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLUE+"2. signup"+ConsoleColor.RESET);
        System.out.println(ConsoleColor.RED+"0. Exit"+ConsoleColor.RESET);
        System.out.print(ConsoleColor.PURPLE+"Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                UserSigning();

            case 2:
                UserSignup();

            case 0:
                System.out.println("Exiting the program. Goodbye :((");
                System.exit(0);

            default:
                System.out.println("*****Invalid choice. Please try again*****");
                UserRun();
        }

        System.out.println();
    }

    public static void UserSigning() {
        System.out.print("Enter username : ");
        String username = scanner.next();
        System.out.print("Enter password : ");
        String password = scanner.next();


        if (ApplicationContext.getUserService().userAuthentication(username, password).getUser_name() != null) {
            SecurityContext.user_name = username;
            SecurityContext.user_id = ApplicationContext.getUserService().userAuthentication(username, password).getUser_id();
            System.out.println("You have logged in!");
            UserMenu.editMenu();
        } else {
            System.out.println("*****Username or password is wrong*****");
            UserMenu.UserSigning();
        }


    }

    public static void UserSignup() {
        String pass_pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        String email_pattern = "(?i)^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        User user = new User();
        System.out.print("enter your name :");
        String name = scanner.next();
        System.out.print("enter your user_name :");
        String user_name = scanner.next();
        System.out.print("enter your email :");
        String email = scanner.next();
        System.out.print("enter your password :");
        String password = scanner.next();
        user.setName(name);
        user.setUser_name(user_name);
        user.setEmail(email);
        user.setPassword(password);
        if (user.getEmail().matches(email_pattern) && user.getPassword().matches(pass_pattern)) {
            if (ApplicationContext.getUserService().isUserNameExist(user.getUser_name())) {
                System.out.println("Error : User Name is NOT Available!*****");
                UserRun();
            }
            if (ApplicationContext.getUserService().isEmailExist(user.getEmail())) {
                System.out.println("*****Error : Email is NOT Available!*****");
                UserRun();
            } else {
                ApplicationContext.getUserService().add(user);
                editMenu();
            }
            ApplicationContext.getUserService().add(user);
            SecurityContext.user_id = user.getUser_id();
            SecurityContext.user_name = user.getUser_name();
        } else {
            System.out.println("*****your email or password(use 8 char and upper and lower and symbol) not correct*****");
            UserRun();
        }
    }

    public static void editMenu() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1.  brand section");
        System.out.println("2.  category section");
        System.out.println("3.  product section");
        System.out.println("4.  shareholder section");
        System.out.println("5.  brands stocks section");
        System.out.println("0. back to the main menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                BrandMenu.brandRun();

            case 2:
                CategoryMenu.categoryRun();

            case 3:
                ProductMenu.productRun();

            case 4:
                ShareHolderMenu.shareHolderRun();

            case 5:
                BuyStockMenu.buyStockRun();

            case 0:
                UserRun();
            default:
                System.out.println("*****Invalid choice. Please try again*****"+ConsoleColor.RESET);
                editMenu();
        }
    }
}
