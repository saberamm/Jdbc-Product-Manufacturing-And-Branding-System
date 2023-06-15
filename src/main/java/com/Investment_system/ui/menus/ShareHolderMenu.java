package com.Investment_system.ui.menus;

import com.Investment_system.model.Shareholder;
import com.Investment_system.util.ApplicationContext;

import java.util.regex.Pattern;

import static com.Investment_system.ui.menus.UserMenu.scanner;

public class ShareHolderMenu {
    static String phonePattern = "^\\d{11}$";
    static String nationalCodePattern = "^\\d{10}$";

    public static void shareHolderRun() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1. add shareHolder");
        System.out.println("2. delete shareHolder");
        System.out.println("3. update shareHolder");
        System.out.println("0. back to the last menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                addShareHolder();

            case 2:
                deleteShareHolder();

            case 3:
                updateShareHolder();

            case 0:
                UserMenu.editMenu();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                shareHolderRun();
        }
    }

    private static void addShareHolder() {
        System.out.print("enter the shareholder name :");
        String name = scanner.next();
        System.out.print("enter the shareholder phone number :");
        String phoneNumber = scanner.next();
        System.out.print("enter the shareholder national code :");
        String nationalCode = scanner.next();
        Shareholder shareholder = new Shareholder(name, phoneNumber, nationalCode);
        if (!Pattern.compile(phonePattern).matcher(phoneNumber).find()){
            System.out.println("*****this phone number is not valid it must be 11 digits*****");
            shareHolderRun();
        }
        if (!Pattern.compile(nationalCodePattern).matcher(nationalCode).find()){
            System.out.println("*****this national code is not valid it must be 11 digits*****");
            shareHolderRun();
        }
            if (ApplicationContext.getShareHolderService().isShareholderExist(nationalCode)) {
                System.out.println("*****shareholder national code is already exist*****");
                shareHolderRun();
            } else {
                ApplicationContext.getShareHolderService().add(shareholder);
                shareHolderRun();
            }
    }

    private static void deleteShareHolder() {
        System.out.print("please enter the shareholder id :");
        int shareHolderId = scanner.nextInt();
        ApplicationContext.getShareHolderService().delete(shareHolderId);
        shareHolderRun();
    }

    private static void updateShareHolder() {
        System.out.print("please enter the shareholder id :");
        int shareholderId = scanner.nextInt();
        System.out.print("enter the shareholder name :");
        String name = scanner.next();
        System.out.print("enter the shareholder phone number :");
        String phoneNumber = scanner.next();
        System.out.print("enter the shareholder national code :");
        String nationalCode = scanner.next();
        Shareholder shareholder = new Shareholder(name, phoneNumber, nationalCode);
        ApplicationContext.getShareHolderService().update(shareholder, shareholderId);
        shareHolderRun();
    }
}
