package com.main;

import com.config.AppConfig;
import com.model.Category;
import com.model.Product;
import com.model.Vendor;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.VendorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        VendorService vendorService = applicationContext.getBean(VendorService.class);
        ProductService productService = applicationContext.getBean(ProductService.class);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("------------------Ecommerce System-------------------");
            System.out.println("1.Insert Product");
            System.out.println("2.Find Product by Id");
            System.out.println("3.Update Stock");
            System.out.println("4.Count products by Vendor");
            System.out.println("0.Exit");
            System.out.println("------------------------------------------------------");

            int option = sc.nextInt();
            if(option == 0){
                System.out.println("Thank you !! Exiting........");
                break;
            }
            switch (option){
                case 1 ->{
                    Category category = new Category();
                    Vendor vendor = new Vendor();
                    Product product = new Product();
                    sc.nextLine();
                    System.out.println("----------------Category Details----------------");
                    System.out.println("Enter the name:");
                    category.setName(sc.nextLine());
                    System.out.println("Enter the description");
                    category.setDescription(sc.nextLine());
                    categoryService.insert(category);
                    System.out.println("-------------------------------------------------");
                    System.out.println("----------------Vendor Details----------------");
                    System.out.println("Enter the name:");
                    vendor.setName(sc.nextLine());
                    System.out.println("Enter the email");
                    vendor.setEmail(sc.nextLine());
                    vendorService.insert(vendor);
                    System.out.println("-------------------------------------------------");
                    System.out.println("----------------Product Details----------------");
                    System.out.println("Enter the name:");
                    product.setName(sc.nextLine());
                    System.out.println("Enter the Price");
                    product.setPrice(sc.nextDouble());
                    System.out.println("Enter the StockQuantity:");
                    product.setStockQuantity(sc.nextInt());

                    product.setCategory_id(category.getId());
                    product.setVendor_id(vendor.getId());
                    productService.saveProduct(product);
                    System.out.println("-------------------------------------------------");
                    break;
                }
            }
        }
    }
}
