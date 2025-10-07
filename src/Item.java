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

    public int getItemNumber(){
        return itemNumber;
    }

    public String getItemDescription(){
        return itemDescription;
    }

    public int getQuantityInStock(){
        return quantityInStock;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void addQuantity(int amountToAdd){
        this.quantityInStock += amountToAdd;
    }

    public void removeQuantity(int amountToRemove){
        this.quantityInStock -= amountToRemove;
    }

}
