package com.Investment_system.ui.menus;

import com.Investment_system.model.Brand;
import com.Investment_system.model.Category;
import com.Investment_system.util.ApplicationContext;

import java.util.regex.Pattern;

import static com.Investment_system.ui.menus.UserMenu.scanner;

public class CategoryMenu {
    public static void categoryRun() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1. add category");
        System.out.println("2. delete category");
        System.out.println("3. update category");
        System.out.println("0. back to the last menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                addCategory();

            case 2:
                deleteCategory();

            case 3:
                updateCategory();

            case 0:
                UserMenu.editMenu();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                categoryRun();
        }
    }

    private static void addCategory() {
        System.out.print("enter the category name :");
        String name = scanner.next();
        System.out.print("enter the category description :");
        String description = scanner.next();
        Category category = new Category(name, description);
        if (ApplicationContext.getCategoryService().isCategoryExist(name)) {
            System.out.println("*****category name is already exist you should use another name*****");
            categoryRun();
        } else {
            ApplicationContext.getCategoryService().add(category);
            categoryRun();
        }
    }

    private static void deleteCategory() {
        System.out.print("please enter the category id :");
        int categoryId = scanner.nextInt();
        ApplicationContext.getCategoryService().delete(categoryId);
        categoryRun();
    }

    private static void updateCategory() {
        System.out.print("please enter the category id :");
        int categoryId = scanner.nextInt();
        System.out.print("enter the category name :");
        String name = scanner.next();
        System.out.print("enter the category description :");
        String description = scanner.next();
        Category category = new Category(name, description);
        ApplicationContext.getCategoryService().update(category, categoryId);
        categoryRun();
    }
}
