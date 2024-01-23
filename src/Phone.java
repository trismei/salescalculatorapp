package SalesCalculatorApp;

public class Phone extends Item {
    private int quantity;

    public Phone(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    @Override
    public double calculateTotalSales() {
        return getPrice() * quantity;
    }
}
