package com.Investment_system.ui.menus;

import com.Investment_system.model.Brand;
import com.Investment_system.model.Category;
import com.Investment_system.model.Product;
import com.Investment_system.model.Shareholder;
import com.Investment_system.util.ApplicationContext;

import static com.Investment_system.ui.menus.UserMenu.scanner;

public class ProductMenu {
    public static void productRun() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1. add product");
        System.out.println("2. delete product");
        System.out.println("3. update product");
        System.out.println("0. back to the last menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                addProduct();

            case 2:
                deleteProduct();

            case 3:
                updateProduct();

            case 0:
                UserMenu.editMenu();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                productRun();
        }
    }

    private static void addProduct() {
        System.out.println("enter product name");
        String name=scanner.next();
        Category[] categoryList = ApplicationContext.getCategoryService().loadAll();
        Brand[] brandList = ApplicationContext.getBrandService().loadAll();
        System.out.println("choose category id");
        for (Category category : categoryList) {
            System.out.println(category);
        }
        int categoryId = scanner.nextInt();

        System.out.println("choose brand id");
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
        int brandId = scanner.nextInt();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        Product product = new Product(name,date,categoryId,brandId);
        productRun();
    }

    private static void deleteProduct() {
        System.out.print("please enter the product id :");
        int productId = scanner.nextInt();
        ApplicationContext.getProductService().delete(productId);
        productRun();
    }

    private static void updateProduct() {
        System.out.print("please enter the product id :");
        int productId = scanner.nextInt();
        System.out.print("enter the product name :");
        String name = scanner.next();
        System.out.print("enter the category id :");
        int categoryId = scanner.nextInt();
        System.out.print("enter the brand id :");
        int brandId = scanner.nextInt();
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        Product product = new Product(name,date,categoryId,brandId );
        ApplicationContext.getProductService().update(product, productId);
        productRun();
    }
}
