package com.Investment_system.util;

import com.Investment_system.connection.DBConnection;
import com.Investment_system.repository.*;
import com.Investment_system.repository.impl.*;
import com.Investment_system.service.*;
import com.Investment_system.service.impl.*;

import java.sql.Connection;

public class ApplicationContext {
    private static Connection connection;

    static {
        connection = new DBConnection().getConnection();
    }

    //-------------user--------------------
    private static UserRepository userRepository;
    private static UserService userService;

    public static UserService getUserService() {
        return userService;
    }

    static {
        userRepository = new UserRepositoryImpl(connection);
        userService = new UserServiceImpl(userRepository);
    }

    //---------------brand--------------------------------
    private static BrandRepository brandRepository;
    private static BrandService brandService;

    public static BrandService getBrandService() {
        return brandService;
    }

    static {
        brandRepository = new BrandRepositoryImpl(connection);
        brandService = new BrandServiceImpl(brandRepository);
    }

    //-----------------category-------------------------------
    private static CategoryRepository categoryRepository;
    private static CategoryService categoryService;

    public static CategoryService getCategoryService() {
        return categoryService;
    }

    static {
        categoryRepository = new CategoryRepositoryImpl(connection);
        categoryService = new CategoryServiceImpl(categoryRepository);
    }
    //------------------shareholder-----------------------------
    private static ShareHolderRepository shareHolderRepository;
    private static ShareHolderService shareHolderService;

    public static ShareHolderService getShareHolderService() {
        return shareHolderService;
    }

    static {
        shareHolderRepository = new ShareHolderRepositoryImpl(connection);
        shareHolderService = new ShareHolderServiceImpl(shareHolderRepository);
    }
    //--------------------product-------------------------------
    private static ProductRepository productRepository;
    private static ProductService productService;

    public static ProductService getProductService() {
        return productService;
    }

    static {
        productRepository = new ProductRepositoryImpl(connection);
        productService = new ProductServiceImpl(productRepository);
    }
    //-------------------shareholder-brand-------------------------
    private static ShareHolderBrandRepository shareHolderBrandRepository;
    private static ShareHolderBrandService shareHolderBrandService;

    public static ShareHolderBrandService getShareHolderBrandService() {
        return shareHolderBrandService;
    }

    static {
        shareHolderBrandRepository = new ShareHolderBrandRepositoryImpl(connection);
        shareHolderBrandService = new ShareHolderBrandServiceImpl(shareHolderBrandRepository);
    }
}
