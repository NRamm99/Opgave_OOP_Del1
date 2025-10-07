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
                    3... Change price
                    4... Calculate basket price
                    
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
                case 3:
                    setPrice(items);
                    break;
                case 4:
                    calculateBasket(items);
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
                int itemNumberToAdd = input.nextInt();
                input.nextLine();

                Item selectedItemToAdd = null;
                for (Item item : items) {
                    if (item.getItemNumber() == itemNumberToAdd) {
                        selectedItemToAdd = item;
                        break;
                    }
                }

                if (selectedItemToAdd == null) {
                    RammTools.printToConsole("No item found with number: " + itemNumberToAdd, false);
                    return;
                }

                RammTools.clearConsole();
                printItems(items, itemNumberToAdd);

                RammTools.printToConsole("\nHow much do you want to add to the stock?", false);
                System.out.print("+ ");
                int amountToAdd = input.nextInt();
                input.nextLine();

                selectedItemToAdd.addQuantity(amountToAdd);

                RammTools.printToConsole("Stock successfully updated!", false);
                break;

            case 2:
                RammTools.clearConsole();
                printItems(items);
                RammTools.printToConsole("\nPlease enter the item number you wish to access.", false);
                System.out.print("Item #: ");
                int itemNumberToRemove = input.nextInt();
                input.nextLine();

                Item selectedItemToRemove = null;
                for (Item item : items) {
                    if (item.getItemNumber() == itemNumberToRemove) {
                        selectedItemToRemove = item;
                        break;
                    }
                }

                if (selectedItemToRemove == null) {
                    RammTools.printToConsole("No item found with number: " + itemNumberToRemove, false);
                    return;
                }

                RammTools.clearConsole();
                printItems(items, itemNumberToRemove);

                RammTools.printToConsole("\nHow much do you want to remove from the stock?", false);
                System.out.print("- ");
                int amountToRemove = input.nextInt();
                input.nextLine();

                selectedItemToRemove.removeQuantity(amountToRemove);

                RammTools.printToConsole("Stock successfully updated!", false);
                break;


            case 3:
                RammTools.clearConsole();
                printItems(items);
                RammTools.printToConsole("\nPlease enter the item number you wish to access.", false);
                System.out.print("Item #: ");
                int itemNumberToChange = input.nextInt();
                input.nextLine();

                Item selectedItemToChange = null;
                for (Item item : items) {
                    if (item.getItemNumber() == itemNumberToChange) {
                        selectedItemToChange = item;
                        break;
                    }
                }

                if (selectedItemToChange == null) {
                    RammTools.printToConsole("No item found with number: " + itemNumberToChange, false);
                    return;
                }

                RammTools.clearConsole();
                printItems(items, itemNumberToChange);

                RammTools.printToConsole("\nHow much do you want to set the current stock to?", false);
                System.out.print("New stock amount: ");
                int newAmount = input.nextInt();
                input.nextLine();

                selectedItemToChange.setQuantity(newAmount);

                RammTools.printToConsole("Stock successfully updated!", false);
                break;

            default:
                break;
        }
    }

    private static void setPrice(ArrayList<Item> items) {
        RammTools.clearConsole();
        printItems(items);
        RammTools.printToConsole("\nPlease enter the item number you wish to access.", false);
        System.out.print("Item #: ");
        int itemNumberToChange = input.nextInt();
        input.nextLine();

        Item selectedItemToChange = null;
        for (Item item : items) {
            if (item.getItemNumber() == itemNumberToChange) {
                selectedItemToChange = item;
                break;
            }
        }

        if (selectedItemToChange == null) {
            RammTools.printToConsole("No item found with number: " + itemNumberToChange, false);
            return;
        }

        RammTools.clearConsole();
        printItems(items, itemNumberToChange);

        RammTools.printToConsole("\nHow much do you want to set the current price to?", false);
        System.out.print("New price: ");
        double newAmount = input.nextDouble();
        input.nextLine();

        selectedItemToChange.setUnitPrice(newAmount);

        RammTools.printToConsole("Price successfully updated!", false);
    }

    private static void calculateBasket(ArrayList<Item> items) {
        int amountToAdd = 0;
        RammTools.clearConsole();
        printItems(items);
        RammTools.printToConsole("\nPlease enter the item number of the first item you wish to add to your basket.", false);
        System.out.print("Item number: ");
        Item itemToAdd = null;
        int itemNumber = input.nextInt();
        input.nextLine();

        ArrayList<Item> basketItems = new ArrayList<>();

        for (Item item : items) {
            if (item.getItemNumber() == itemNumber) {
                itemToAdd = item;
                RammTools.printToConsole("Succes!", true);
                RammTools.printToConsole(item.getItemDescription() + " has been added to the cart.", false);
                RammTools.printToConsole("\nHow many (" + item.getItemDescription() + ") do you wish to add to your cart?", false);
                System.out.print(item.getItemDescription() + " x ");
                amountToAdd = input.nextInt();
                input.nextLine();

                for (int n = 0; n < amountToAdd; n++) {
                    basketItems.add(itemToAdd);
                }
            }
        }
        if (itemToAdd == null) {
            RammTools.printToConsole("No item with that number was found.");
        }
        boolean makingBasket = true;
        while (makingBasket) {
            RammTools.clearConsole();
            RammTools.printToConsole("---------- BASKET ----------");
            printBasket(basketItems);
            RammTools.printToConsole("""
                    \n---------- BASKET CALCULATOR ----------
                    1... Add another item
                    2... Calculate now
                    """, false);
            int userInput = input.nextInt();
            input.nextLine();

            switch (userInput) {
                case 1:
                    amountToAdd = 0;
                    RammTools.clearConsole();
                    printItems(items);
                    RammTools.printToConsole("Please enter the item number of the item you wish to add to your basket.");
                    System.out.print("Item number: ");
                    itemToAdd = null;
                    itemNumber = input.nextInt();
                    input.nextLine();

                    for (Item item : items) {
                        if (item.getItemNumber() == itemNumber) {
                            itemToAdd = item;
                            RammTools.printToConsole("Succes!", true);
                            RammTools.printToConsole(item.getItemDescription() + " has been added to the cart.", false);
                            RammTools.printToConsole("\nHow many (" + item.getItemDescription() + ") do you wish to add to your cart?", false);
                            System.out.print(item.getItemDescription() + " x ");
                            amountToAdd = input.nextInt();
                            input.nextLine();

                            for (int n = 0; n < amountToAdd; n++) {
                                basketItems.add(itemToAdd);
                            }
                        }
                    }
                    if (itemToAdd == null) {
                        RammTools.printToConsole("No item with that number was found.");
                    }
                    break;

                case 2:
                    makingBasket = false;
            }

        }

        printBasket(basketItems);
        RammTools.waitForUser(input);


    }

    private static void printBasket(ArrayList<Item> basketItems) {
        // PRINT BASKET AND FINAL PRICE
        double sum = 0;
        for (Item item : basketItems) {
            sum += item.getUnitPrice();
        }
        RammTools.printToConsole("---------- BASKET ----------");
        for (Item item : basketItems) {
            RammTools.printToConsole("1 x " + item.getItemDescription() + " | Price: $" + item.getUnitPrice(), false);
        }
        RammTools.printToConsole("----------------------------", false);
        RammTools.printToConsole("TOTAL: $" + sum, false);
    }


}