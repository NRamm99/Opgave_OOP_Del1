import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        RammTools.clearConsole();

        items.add(new Item(1, "White powder", 3, 19.99));
        items.add(new Item(2, "Black powder", 5, 24.99));
        items.add(new Item(3, "Yellow powder", 4, 9.99));
        items.add(new Item(4, "Green powder", 7, 20.00));

        promptMainMenu(items);
    }

    private static void printItems(ArrayList<Item> items) {
        for (Item item : items) {
            RammTools.printToConsole("Item #" + item.getItemNumber() + ": " + item.getItemDescription()
                    + " | Quantity: " + item.getQuantityInStock() + " | Price: $" + item.getUnitPrice(), false);
        }
    }

    private static void printItems(ArrayList<Item> items, int itemNumber) {

        for (Item item : items) {
            if (item.getItemNumber() == itemNumber) {
                RammTools.printToConsole("Success! Item was found:", false);
                RammTools.printToConsole(
                        "Item #" + item.getItemNumber() + ": " + item.getItemDescription()
                                + " | Quantity: " + item.getQuantityInStock()
                                + " | Price: $" + item.getUnitPrice(),
                        false
                );
                return;
            }
        }

        RammTools.printToConsole("No item found with number: " + itemNumber, false);
    }

    private static void promptMainMenu(ArrayList<Item> items) {
        while (true) {

            RammTools.printToConsole("""
                    ---------- MENU ----------
                    1... Print inventory
                    2... Change Stock
                    
                    0... Quit
                    """);
            int userInput = input.nextInt();
            input.nextLine();
            switch (userInput) {
                case 1:
                    RammTools.clearConsole();
                    printItems(items);
                    RammTools.waitForUser(input);
                    break;
                case 2:
                    promptStockMenu(items);
                    break;
                case 0:
                    return;
                default:
                    RammTools.printToConsole("Input not recognized. Please try again.", false);
                    break;
            }
        }

    }

    private static void promptStockMenu(ArrayList<Item> items) {
        RammTools.printToConsole("""
                ---------- STOCK MENU ----------
                1... Add stock
                2... Remove stock
                3... Set stock
                
                0... Quit
                """);
        int userInput = input.nextInt();
        input.nextLine();

        switch (userInput) {
            case 1:
                RammTools.clearConsole();
                printItems(items);
                RammTools.printToConsole("\nPlease enter the item number you wish to access.", false);
                System.out.print("Item #: ");
                int itemNumber = input.nextInt();
                input.nextLine();

                Item selectedItem = null;
                for (Item item : items) {
                    if (item.getItemNumber() == itemNumber) {
                        selectedItem = item;
                        break;
                    }
                }

                if (selectedItem == null) {
                    RammTools.printToConsole("No item found with number: " + itemNumber, false);
                    return;
                }

                RammTools.clearConsole();
                printItems(items, itemNumber);

                RammTools.printToConsole("\nHow much do you want to add to the stock?", false);
                System.out.print("+ ");
                int amountToAdd = input.nextInt();
                input.nextLine();

                selectedItem.addQuantity(amountToAdd);

                RammTools.printToConsole("Stock successfully updated!", false);
                break;

        }
    }
}