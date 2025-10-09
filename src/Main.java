import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        RammTools.printToConsole("""
                ---------- MENU ----------
                1... Item class
                2... Point class
                """);
        int userInput = input.nextInt();
        input.nextLine();
        switch (userInput) {
            case 1:
                initializeBasketProgram();
                break;
            case 2:
                promptPointMenu();
                break;
            default:
                RammTools.printToConsole("Input not recognized. Please try again.", false);
                break;
        }

    }

    private static void initializeBasketProgram() {

        ArrayList<Item> items = new ArrayList<>();


        items.add(new Item(1, "White powder", 3, 19.99));
        items.add(new Item(2, "Black powder", 5, 24.99));
        items.add(new Item(3, "Yellow powder", 4, 9.99));
        items.add(new Item(4, "Green powder", 7, 20.00));

        RammTools.clearConsole();
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
                    3... Change price of an item
                    4... Calculate basket price
                    5... Increase all prices
                    6... Calculate inventory value
                    
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
                case 5:
                    increaseAllPrices(items);
                    break;
                case 6:
                    calculateInventory(items);
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

    private static void calculateInventory(ArrayList<Item> items) {
        double sum = 0;
        for (Item item : items) {
            for (int n = 0; n < item.getQuantityInStock(); n++) {
                sum += item.getUnitPrice();
            }
        }
        RammTools.printToConsole("---------- STOCK AND PRICES ----------");
        printItems(items);
        RammTools.printToConsole("\nTOTAL INVENTORY VALUE: $" + String.format("%.2f", sum), false);
        RammTools.waitForUser(input);
    }

    private static void calculateBasket(ArrayList<Item> items) {
        int amountToAdd;
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

    private static void increaseAllPrices(ArrayList<Item> items) {
        RammTools.printToConsole("---------- STOCK AND PRICES ----------");
        printItems(items);

        System.out.print("\n\n\nIncrease all prices by + ");
        int amountToIncrease = input.nextInt();
        input.nextLine();

        for (Item item : items) {
            item.setUnitPrice((amountToIncrease + item.getUnitPrice()));
        }
    }

    private static void printBasket(ArrayList<Item> basketItems) {
        int DISCOUNT_AMOUNT = 5;

        double sum = 0;
        double sumDiscounted = 0;
        for (Item item : basketItems) {
            sum += item.getUnitPrice();
            sumDiscounted += item.getUnitPrice();
            if (item.getQuantityInStock() <= DISCOUNT_AMOUNT) {
                sum += item.getUnitPrice();
                sumDiscounted += (item.getUnitPrice() * 0.80);

            }
        }
        RammTools.printToConsole("---------- BASKET ----------");
        for (Item item : basketItems) {
            RammTools.printToConsole("1 x " + item.getItemDescription() + " | Price: $" + item.getUnitPrice(), false);
        }
        RammTools.printToConsole("----------------------------", false);
        RammTools.printToConsole("BEFORE DISCOUNT | TOTAL: $" + String.format("%.2f", sum), false);
        RammTools.printToConsole("AFTER DISCOUNT | TOTAL: $" + String.format("%.2f", sumDiscounted), false);
    }

    private static void promptPointMenu() {
        ArrayList<Point> points = new ArrayList<>();


        points.add(new Point(10, 20, 1));
        points.add(new Point(23, 34, 2));
        points.add(new Point(20, 20, 3));
        points.add(new Point(30, 20, 4));

        while (true) {

            RammTools.printToConsole("""
                    ---------- POINT MENU ----------
                    1... Calculate distance between to points
                    2... move point (x)
                    3... move point (y)
                    4... move point (x + y)
                    
                    0... Quit
                    """);
            int userInput = input.nextInt();
            input.nextLine();
            switch (userInput) {
                case 1:
                    calculateDistance(points);
                    break;
                case 2:
                    moveX(points);
                    break;
                case 3:
                    moveY(points);
                    break;
                case 4:
                    movePoint(points);
                    break;
                case 5:
                    moveAllPoints(points);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Error: Please enter a valid input");
                    break;
            }
        }
    }

    private static void moveAllPoints(ArrayList<Point> points) {
        RammTools.printToConsole("---------- POINT MOVER ----------");
        printPoints(points);
        System.out.println("\n\nYou are about to move ALL points.");

        RammTools.printToConsole("---------- POINT MOVER ----------");
        System.out.print("How much do you want to change the x value: ");
        double moveX = input.nextDouble();
        System.out.print("\nHow much do you want to change the y value: ");
        double moveY = input.nextDouble();

        for (Point point : points) {
            point.move(moveX, moveY);
        }
    }

    private static void movePoint(ArrayList<Point> points) {
        Point movePoint = null;
        RammTools.printToConsole("---------- POINT MOVER ----------");
        printPoints(points);
        System.out.print("\n\nEnter the id of the point you wish to move: ");
        int userinput = input.nextInt();
        input.nextLine();
        for (Point point : points) {
            if (point.getId() == userinput) {
                movePoint = point;
            }
        }
        if (movePoint == null) {
            System.out.println("ERROR");
            return;
        }
        RammTools.printToConsole("---------- POINT MOVER ----------");
        System.out.println("CHOSEN POINT: x = " + movePoint.getX() + " | y = " + movePoint.getY());
        System.out.print("How much do you want to change the x value: ");
        double moveX = input.nextDouble();
        System.out.print("\nHow much do you want to change the y value: ");
        double moveY = input.nextDouble();

        movePoint.move(moveX, moveY);
    }

    private static void moveX(ArrayList<Point> points) {
        Point movePoint = null;
        RammTools.printToConsole("---------- POINT MOVER ----------");
        printPoints(points);
        System.out.print("\n\nEnter the id of the point you wish to move on the x-axis: ");
        int userinput = input.nextInt();
        input.nextLine();
        for (Point point : points) {
            if (point.getId() == userinput) {
                movePoint = point;
            }
        }
        if (movePoint == null) {
            System.out.println("ERROR");
            return;
        }
        RammTools.printToConsole("---------- POINT MOVER ----------");
        System.out.println("CHOSEN POINT: x = " + movePoint.getX() + " | y = " + movePoint.getY());
        System.out.print("How much do you want to change the x value: ");
        movePoint.moveX(input.nextDouble());
        input.nextLine();
    }

    private static void moveY(ArrayList<Point> points) {
        Point movePoint = null;
        RammTools.printToConsole("---------- POINT MOVER ----------");
        printPoints(points);
        System.out.print("\n\nEnter the id of the point you wish to move on the y-axis: ");
        int userinput = input.nextInt();
        input.nextLine();
        for (Point point : points) {
            if (point.getId() == userinput) {
                movePoint = point;
            }
        }
        if (movePoint == null) {
            System.out.println("ERROR");
            return;
        }
        RammTools.printToConsole("---------- POINT MOVER ----------");
        System.out.println("CHOSEN POINT: x = " + movePoint.getX() + " | y = " + movePoint.getY());
        System.out.print("How much do you want to change the y value: ");
        movePoint.moveY(input.nextDouble());
        input.nextLine();
    }


    private static void printPoints(ArrayList<Point> points) {
        for (Point point : points) {
            System.out.println(point.getId() + ": (" + point.getX() + "/" + point.getY() + ")");
        }
    }

    private static void calculateDistance(ArrayList<Point> points) {
        Point A = null;
        Point B = null;

        RammTools.printToConsole("---------- DISTANCE CALCULATOR ----------");
        printPoints(points);
        System.out.print("Enter id for point A: ");
        int findA = input.nextInt();
        input.nextLine();
        for (Point point : points) {
            if (point.getId() == findA) {
                A = point;
            }
        }

        System.out.print("Enter id for point B: ");
        int findB = input.nextInt();
        input.nextLine();
        for (Point point : points) {
            if (point.getId() == findB) {
                B = point;
            }
        }


        assert A != null;
        double x_1 = A.getX();
        double y_1 = A.getY();
        assert B != null;
        double x_2 = B.getX();
        double y_2 = B.getY();
        double distance = Math.sqrt(Math.pow((x_2 - x_1), 2) + Math.pow((y_2 - y_1), 2));

        RammTools.printToConsole("DISTANCE CALCULATED!");
        RammTools.printToConsole("Distance: " + String.format("%.2f", distance),false);
        RammTools.waitForUser(input);
    }


}