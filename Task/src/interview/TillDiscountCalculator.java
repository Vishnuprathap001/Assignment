package interview;

import java.util.Scanner;

public class TillDiscountCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfItems = Integer.parseInt(scanner.nextLine());

        Receipt receipt = new Receipt();

        for (int i = 0; i < numberOfItems; i++) {
            String[] inputParts = scanner.nextLine().split(" at ");
            String name = inputParts[0].trim();
            double price = Double.parseDouble(inputParts[1].trim());
            boolean isClearance = name.toLowerCase().contains("clearance");
            String category = determineCategory(name);

            Item item = new Item(name, price, isClearance, category);
            receipt.addItem(item);
        }
        
        receipt.printTotal();
        scanner.close();
    }

    private static String determineCategory(String itemName) {
        if (itemName.toLowerCase().contains("book") 
        		|| itemName.toLowerCase().contains("chocolate") 
        		|| itemName.toLowerCase().contains("drink")
        		|| itemName.toLowerCase().contains("wine")
        		|| itemName.toLowerCase().contains("food")) {
            return "food";
        } else if (itemName.toLowerCase().contains("shirt") 
        		|| itemName.toLowerCase().contains("dress") 
        		|| itemName.toLowerCase().contains("cloth")) {
            return "clothes";
        } else {
            return "other";
        }
    }
}
