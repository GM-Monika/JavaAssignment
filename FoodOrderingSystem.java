
package com.example.food;

import java.util.*;

class FoodItem {
    String name;
    double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class FoodOrderingSystem {

    static final double TAX_RATE = 0.05;
    static final double DELIVERY_CHARGE = 50.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Food Menu
        List<FoodItem> menu = Arrays.asList(
                new FoodItem("Burger", 150),
                new FoodItem("Pizza", 250),
                new FoodItem("Fries", 100),
                new FoodItem("Coke", 50)
        );

        Map<Integer, Integer> cart = new HashMap<>();

        // Display Menu
        System.out.println("------ MENU ------");
        for (int i = 0; i < menu.size(); i++) {
            FoodItem item = menu.get(i);
            System.out.printf("%d. %s - ₹%.2f%n", i + 1, item.name, item.price);
        }

        // Add Items
        String choice;
        do {
            System.out.print("Enter item number to add to cart: ");
            int itemNumber = scanner.nextInt();
            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();

            cart.put(itemNumber - 1, cart.getOrDefault(itemNumber - 1, 0) + qty);

            System.out.print("Add more items? (yes/no): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("yes"));

        // Calculate Total
        double subtotal = 0;
        System.out.println("\n--- Your Cart ---");
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            FoodItem item = menu.get(entry.getKey());
            int quantity = entry.getValue();
            double itemTotal = item.price * quantity;
            subtotal += itemTotal;
            System.out.printf("%s x %d = ₹%.2f%n", item.name, quantity, itemTotal);
        }

        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax + DELIVERY_CHARGE;

        // Special instructions
        scanner.nextLine();  // consume newline
        System.out.print("\nAny special instructions for your order? ");
        String instructions = scanner.nextLine();

        // Output
        System.out.println("\n--- Bill Summary ---");
        System.out.printf("Subtotal: ₹%.2f%n", subtotal);
        System.out.printf("Tax (5%%): ₹%.2f%n", tax);
        System.out.printf("Delivery Charge: ₹%.2f%n", DELIVERY_CHARGE);
        System.out.printf("Total: ₹%.2f%n", total);
        System.out.println("Special Instructions: " + instructions);

        scanner.close();
    }
}
