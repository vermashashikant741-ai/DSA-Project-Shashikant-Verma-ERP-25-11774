import java.util.*;

public class Main {

    // Product Class
    static class Product {
        int id;
        String name;
        String category;
        double price;
        int quantity;

        Product(int id, String name, String category,
                double price, int quantity) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.quantity = quantity;
        }

        void display() {
            System.out.printf("%-8d %-18s %-15s %-12.2f %-10d%n",
                    id, name, category, price, quantity);
        }
    }

    // HashMap and ArrayList
    static HashMap<Integer, Product> products = new HashMap<>();
    static ArrayList<Product> productList = new ArrayList<>();

    // Add Product
    static void addProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (products.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        if (price < 0 || quantity < 0) {
            System.out.println("Invalid price or quantity!");
            return;
        }

        Product p = new Product(id, name, category, price, quantity);

        products.put(id, p);
        productList.add(p);

        System.out.println("Product Added Successfully!");
    }

    // Display All Products
    static void displayProducts() {

        if (productList.isEmpty()) {
            System.out.println("No Products Available!");
            return;
        }

        System.out.println("\n---------------- PRODUCT LIST ----------------");

        System.out.printf("%-8s %-18s %-15s %-12s %-10s%n",
                "ID", "NAME", "CATEGORY", "PRICE", "QUANTITY");

        for (Product p : productList) {
            p.display();
        }
    }

    // Search Product by ID using HashMap
    static void searchById(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = products.get(id);

        if (p != null) {
            System.out.println("Product Found:");
            p.display();
        } else {
            System.out.println("Product Not Found!");
        }
    }

    // Search Product by Name using Linear Search
    static void searchByName(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Product p : productList) {

            if (p.name.toLowerCase().contains(name.toLowerCase())) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product Not Found!");
        }
    }

    // Update Product
    static void updateProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = products.get(id);

        if (p == null) {
            System.out.println("Product Not Found!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter New Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Category: ");
        String category = sc.nextLine();

        System.out.print("Enter New Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        if (price < 0 || quantity < 0) {
            System.out.println("Invalid price or quantity!");
            return;
        }

        p.name = name;
        p.category = category;
        p.price = price;
        p.quantity = quantity;

        System.out.println("Product Updated Successfully!");
    }

    // Delete Product
    static void deleteProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = products.remove(id);

        if (p != null) {
            productList.remove(p);
            System.out.println("Product Deleted Successfully!");
        } else {
            System.out.println("Product Not Found!");
        }
    }

    // Sort Products by Price
    static void sortByPrice() {

        productList.sort(Comparator.comparingDouble(p -> p.price));

        System.out.println("\nProducts Sorted by Price:");
        displayProducts();
    }

    // Sort Products by Name
    static void sortByName() {

        productList.sort(
                Comparator.comparing(p -> p.name.toLowerCase())
        );

        System.out.println("\nProducts Sorted by Name:");
        displayProducts();
    }

    // Low Stock Products
    static void lowStock() {

        System.out.println("\n----------- LOW STOCK PRODUCTS -----------");

        boolean found = false;

        for (Product p : productList) {

            if (p.quantity < 5) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Low Stock Products!");
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("       SMARTCART E-COMMERCE SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Update Product");
            System.out.println("6. Delete Product");
            System.out.println("7. Sort Products by Price");
            System.out.println("8. Sort Products by Name");
            System.out.println("9. Low Stock Products");
            System.out.println("10. Exit");

            System.out.print("\nEnter Your Choice: ");

             choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct(sc);
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchById(sc);
                    break;

                case 4:
                    searchByName(sc);
                    break;

                case 5:
                    updateProduct(sc);
                    break;

                case 6:
                    deleteProduct(sc);
                    break;

                case 7:
                    sortByPrice();
                    break;

                case 8:
                    sortByName();
                    break;

                case 9:
                    lowStock();
                    break;

                case 10:
                    System.out.println("\nThank You for Using SmartCart!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 10);

        sc.close();
    }
}
    

