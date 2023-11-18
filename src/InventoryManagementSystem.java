import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    // This is a static variable.It is shared by all instances of the class.
    // This means that if you create two InventoryManagementSystem
    // objects, they will both share the same inventory.
    private static final ArrayList<InventoryItem> inventory = new ArrayList<>(); // This is an ArrayList of InventoryItem objects.
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Remove Item");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // For Add Item
                    addItem();
                    break;
                case 2: // For View Inventory
                    viewInventory();
                    break;
                case 3: // For Remove Item
                    removeItem();
                    break;
                case 4: // For Exit
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    System.exit(0);
                default: // For invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a new item to the inventory ArrayList
    private static void addItem() {
        System.out.print("Enter item name: ");
        String itemName = userInput.nextLine();

        System.out.print("Enter initial stock quantity: ");
        int stockQuantity = userInput.nextInt();

        // Create a new InventoryItem object and add it to the inventory ArrayList
        InventoryItem newItem = new InventoryItem(itemName, stockQuantity);
        inventory.add(newItem); // Add the new item to the inventory ArrayList

        System.out.println("Item added successfully!");
    }

    // View the inventory ArrayList and print out the items
    private static void viewInventory() {
        if (inventory.isEmpty()) { // Check if the inventory ArrayList is empty
            System.out.println("Inventory is empty.");
        } else { // If the inventory ArrayList is not empty, print out the items
            System.out.println("Inventory:");
            System.out.printf("%-20s %s\n", "Item Name", "Stock Quantity");
            System.out.printf("%-20s %s\n", "---------", "--------------");

            // Loop through the inventory ArrayList and print out the items
            for (InventoryItem item : inventory) {
                System.out.printf("%-20s %d\n", item.itemName, item.stockQuantity);
            }
        }
    }

    // Remove an item from the inventory ArrayList
    private static void removeItem() {
        if (inventory.isEmpty()) { // Check if the inventory ArrayList is empty
            System.out.println("Inventory is empty. Nothing to remove.");
            return;
        }

        System.out.print("Enter the name of the item to remove: ");
        String itemName = userInput.nextLine();

        boolean itemRemoved = false; // Flag to check if the item was removed

        for (InventoryItem item : inventory) {

            // Loop through the inventory ArrayList and remove the item if it is found
            if (item.itemName.equalsIgnoreCase(itemName)) {
                inventory.remove(item); // Remove the item from the inventory ArrayList
                itemRemoved = true; // Set the flag to true
                System.out.println("Item removed successfully!");
                break;
            }
        }

        // If the item was not removed, print out a message
        if (!itemRemoved) {
            System.out.println("Item not found in the inventory.");
        }
    }
}
