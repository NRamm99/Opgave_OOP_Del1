public class Item {
    private int itemNumber;
    private String itemDescription;
    private int quantityInStock;
    private double unitPrice;

    public Item(int itemNumber, String itemDescription, int quantityInStock, double unitPrice) {
        this.itemNumber = itemNumber;
        this.itemDescription = itemDescription;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return "Item #" + itemNumber + ": " + itemDescription +
                " | Quantity: " + quantityInStock +
                " | Price: $" + String.format("%.2f", unitPrice);
    }

}
