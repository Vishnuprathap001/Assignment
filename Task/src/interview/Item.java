package interview;

public class Item {
    private String name;
    private double price;
    private boolean isClearance;
    private String category;

    public Item(String name, double price, boolean isClearance, String category) {
        this.name = name;
        this.price = price;
        this.isClearance = isClearance;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isClearance() {
        return isClearance;
    }

    public String getCategory() {
        return category;
    }

    public double calculateDiscount() {
        double discount = 0.0;
        switch (category.toLowerCase()) {
            case "food":
                discount = 0.05;
                break;
            case "clothes":
                discount = 0.20;
                break;
            default:
                discount = 0.03;
                break;
        }

        double discountedPrice = price * (1 - discount);

        if (isClearance) {
            discountedPrice *= 0.8;
        }

        return Math.round(discountedPrice * 100.0) / 100.0;
    }
}
