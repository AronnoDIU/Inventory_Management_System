import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    private static final ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Remove Item");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewInventory();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter initial stock quantity: ");
        int stockQuantity = scanner.nextInt();

        InventoryItem newItem = new InventoryItem(itemName, stockQuantity);
        inventory.add(newItem);

        System.out.println("Item added successfully!");
    }

    private static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            System.out.printf("%-20s %s\n", "Item Name", "Stock Quantity");
            for (InventoryItem item : inventory) {
                System.out.printf("%-20s %d\n", item.itemName, item.stockQuantity);
            }
        }
    }

    private static void removeItem() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Nothing to remove.");
            return;
        }

        System.out.print("Enter the name of the item to remove: ");
        String itemName = scanner.nextLine();

        boolean itemRemoved = false;
        for (InventoryItem item : inventory) {
            if (item.itemName.equalsIgnoreCase(itemName)) {
                inventory.remove(item);
                itemRemoved = true;
                System.out.println("Item removed successfully!");
                break;
            }
        }

        if (!itemRemoved) {
            System.out.println("Item not found in the inventory.");
        }
    }
}
