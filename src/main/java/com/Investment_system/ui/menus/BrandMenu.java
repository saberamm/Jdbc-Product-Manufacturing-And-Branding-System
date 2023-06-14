package com.Investment_system.ui.menus;

import com.Investment_system.model.Brand;
import com.Investment_system.util.ApplicationContext;

import java.util.regex.Pattern;

import static com.Investment_system.ui.menus.UserMenu.scanner;

public class BrandMenu {
    static String webPattern = "^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$";

    public static void brandRun() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1. add brand");
        System.out.println("2. delete brand");
        System.out.println("3. update brand");
        System.out.println("0. back to the last menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                addBrand();

            case 2:
                deleteBrand();

            case 3:
                updateBrand();

            case 0:
                UserMenu.editMenu();
            default:
                System.out.println("Invalid choice. Please try again.");
                brandRun();
        }
    }

    public static void addBrand() {
        System.out.print("enter the brand name :");
        String name = scanner.next();
        System.out.print("enter the brand website :");
        String website = scanner.next();
        System.out.print("enter the brand description :");
        String description = scanner.next();
        Brand brand = new Brand(name, website, description);
        if (ApplicationContext.getBrandService().isBrandExist(name)) {
            System.out.println("brand name is already exist you should use another name");
            brandRun();
        } else {
            if (Pattern.compile(webPattern).matcher(website).find()) {
                ApplicationContext.getBrandService().add(brand);
                brandRun();
            } else {
                System.out.println("this website address is not valid");
                brandRun();
            }
        }
    }


    public static void deleteBrand() {
        System.out.print("please enter the brand id");
        int brandId = scanner.nextInt();
        ApplicationContext.getBrandService().delete(brandId);
        brandRun();
    }

    public static void updateBrand() {
        System.out.print("please enter the brand id :");
        int brandId = scanner.nextInt();
        System.out.print("enter the brand name :");
        String name = scanner.next();
        System.out.print("enter the brand website :");
        String website = scanner.next();
        System.out.print("enter the brand description :");
        String description = scanner.next();
        Brand brand = new Brand(name, website, description);
        if (Pattern.compile(webPattern).matcher(website).find()) {
            ApplicationContext.getBrandService().update(brand, brandId);
            brandRun();
        } else {
            System.out.println("this website address is not valid");
            brandRun();
        }
    }
}
