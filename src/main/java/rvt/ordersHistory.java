package rvt;
import java.util.Scanner;
import java.io.File;

public class ordersHistory {
    public static void main (String[] args){
        double amount = 0.0;
        try(Scanner scanner = new Scanner(new File("data/orders.csv"))){
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String row = scanner.nextLine();
                String[] parts = row.split(",");

                int orderID = Integer.valueOf(parts[0]);
                String customer = parts[1];
                String product = parts[2];
                int quantity = Integer.valueOf(parts[3]);
                double price = Double.parseDouble(parts[4]);

                amount += price * quantity;
                System.out.printf("Pasūtījums #%d: %s pasūtīja %d x %s (%.2f EUR)%n", orderID, customer, quantity, product, price);
            }
            System.out.printf("Kopējā pasūtījumu summa: %.2f EUR", amount);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
