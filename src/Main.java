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

        printItems(items);
    }

    private static void printItems(ArrayList<Item> items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}