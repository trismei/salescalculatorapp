package SalesCalculatorApp;

public class RepairService extends Item {
    private int hours;

    public RepairService(String name, double price, int hours) {
        super(name, price);
        this.hours = hours;
    }

    @Override
    public double calculateTotalSales() {
        return getPrice() * hours; // Use the price from the Item superclass
    }
}
