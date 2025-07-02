package org.example;

import java.util.*;

public class Main {

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        if (quantity <= 0) {
            System.out.println("Quantity must be positive");
            System.out.println("---------------");
            return;
        }

        for (int i = 0; i < pizzas.size(); i++) {
            if (pizzas.get(i).equalsIgnoreCase(pizzaType)) {
                quantities.set(i, quantities.get(i) + quantity);
                System.out.println("Added " + quantity + " more to existing order: " + pizzaType);
                System.out.println("---------------");
                return;
            }
        }

        pizzas.add(pizzaType);
        quantities.add(quantity);
        System.out.println("Order added: " + pizzaType + " x" + quantity);
        System.out.println("---------------");
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        if (index < 0 || index >= quantities.size()) {
            System.out.println("Invalid order number.");
        } else if (newQuantity <= 0) {
            System.out.println("Quantity must be positive");
        } else {
            quantities.set(index, newQuantity);
            System.out.println("Order updated to quantity " + newQuantity);
        }
        System.out.println("---------------");
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if (index < 0 || index >= pizzas.size()) {
            System.out.println("Invalid order number.");
        } else {
            String removedPizza = pizzas.remove(index);
            int removedQuantity = quantities.remove(index);
            System.out.println("Removed order: " + removedPizza + " x" + removedQuantity);
        }
        System.out.println("---------------");
    }

    public static void printOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities){
        if (pizzas.isEmpty()) {
            System.out.println("No current orders.");
        } else {
            System.out.println("----- Current Orders -----");
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.println((i + 1) + ". " + pizzas.get(i) + "  x " + quantities.get(i));
            }
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to GCash Pizzeria!");
        System.out.println("1. Add order");
        System.out.println("2. Update order");
        System.out.println("3. Remove order");
        System.out.println("4. View orders");
        System.out.println("5. Exit");

        while (true) {

            System.out.print("Choose an option: ");
            int optionOrder = scanner.nextInt();
            scanner.nextLine();

            if (optionOrder == 5) {
                System.out.println("Your food will be up shortly. Thank you!");
                break;
            }

            switch (optionOrder) {
                case 1:
                    System.out.print("Pizza Type: ");
                    String pizzaType = scanner.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;

                case 2:
                    printOrder(pizzas, quantities);
                    System.out.print("Order number to update: ");
                    int updateIndex = scanner.nextInt() - 1;

                    System.out.print("New quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();

                    updateOrder(quantities, updateIndex, newQuantity);
                    break;

                case 3:
                    System.out.print("Order number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    removeOrder(pizzas, quantities, removeIndex);
                    break;

                case 4:
                    printOrder(pizzas, quantities);
                    break;

                default:
                    System.out.println("Invalid number. Please try again.");
                    System.out.println("---------------");
            }
        }
        scanner.close();
    }
}