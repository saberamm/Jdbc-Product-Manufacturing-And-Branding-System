package com.Investment_system.ui.menus;

import com.Investment_system.model.Brand;
import com.Investment_system.model.Shareholder;
import com.Investment_system.util.ApplicationContext;

import static com.Investment_system.ui.menus.UserMenu.scanner;

public class BuyStockMenu {

    public static void buyStockRun() {
        int choice;
        System.out.println("================");
        System.out.println("Options:");
        System.out.println("1. buy stock");
        System.out.println("2. sales stock");
        System.out.println("0. back to the last menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                buyStock();

            case 2:
                saleStock();

            case 0:
                UserMenu.editMenu();
            default:
                System.out.println("*****Invalid choice. Please try again*****");
                buyStockRun();
        }
    }

    private static void buyStock() {
        Shareholder[] shareholdersList = ApplicationContext.getShareHolderService().loadAll();
        Brand[] brandList = ApplicationContext.getBrandService().loadAll();
        for (Shareholder shareholder : shareholdersList) {
            System.out.println(shareholder);
        }
        System.out.println("choose share holder id");
        int shareHolderId = scanner.nextInt();
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
        System.out.println("choose brand id");
        int brandId=scanner.nextInt();
        ApplicationContext.getShareHolderBrandService().add(shareHolderId,brandId);
        buyStockRun();
    }

    private static void saleStock() {
        System.out.print("please enter the stock id :");
        int stockId = scanner.nextInt();
        ApplicationContext.getShareHolderBrandService().delete(stockId);
        buyStockRun();
    }
}
