package interview;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Item> items;
    private double totalSaved;

    public Receipt() {
        this.items = new ArrayList<>();
        this.totalSaved = 0.0;
    }

    public void addItem(Item item) {
        double savings = item.getPrice() - item.calculateDiscount();
        totalSaved += savings;
        items.add(item);
    }

    public void printTotal() {
    	DecimalFormat df = new DecimalFormat("#0.00");
    	double total = 0;
    	for(Item item : items) {
    		double discount = item.calculateDiscount();
    		System.out.println(item.getName() + " at " + df.format(discount));
    		total += discount;
    	}
        System.out.println("Total: " + df.format((Math.round(total * 100.0) / 100.0)));
        System.out.println("You saved: " + df.format(Math.round(totalSaved * 100.0) / 100.0));
    }
}

