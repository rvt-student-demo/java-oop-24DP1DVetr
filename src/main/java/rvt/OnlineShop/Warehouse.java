package rvt.OnlineShop;

import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private HashMap<String, Integer> prices;
    private HashMap<String, Integer> stocks;

    public Warehouse() {
        prices = new HashMap<>();
        stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);
    }

    public int price(String product) {
        return prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return stocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (!stocks.containsKey(product)) {
            return false;
        }
        int currentStock = stock(product);

        if (currentStock > 0) {
            stocks.put(product, currentStock - 1);
            return true;
        }
        return false;
    }

    public Set<String> products(){
        return stocks.keySet();
    }
}