package org.marvin.application;

import org.marvin.entities.ImportedProduct;
import org.marvin.entities.Product;
import org.marvin.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        List<Product> products = new ArrayList<>();

        for(int i=1; i<=n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char typeProduct = sc.next().charAt(0);

            if(typeProduct == 'i'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                ImportedProduct imp = new ImportedProduct(name, price, customsFee);
                products.add(imp);
            }
            if(typeProduct == 'c'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();

                Product p = new Product(name, price);
                products.add(p);
            }
            if(typeProduct == 'u'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                Date date = formatter.parse(sc.nextLine());

                UsedProduct up = new UsedProduct(name, price, date);
                products.add(up);
            }
        }

        System.out.println("PRICE TAGS:");
        for(Product product : products){
            System.out.println(product.priceTag());
        }

        sc.close();

    }
}
