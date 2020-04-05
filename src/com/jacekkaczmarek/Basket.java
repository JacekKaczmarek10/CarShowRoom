package com.jacekkaczmarek;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<CarItem, Integer> list;


    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public boolean contain(String name) {
        for (Map.Entry<CarItem, Integer> entry : list.entrySet()) {
            if (entry.getKey().getName().equals(name))
                return true;
        }
        return false;
    }


    public int addToBasket(CarItem item, int quantity) {
        if ( (item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int deleteFromBasket(CarItem item, int quantity) {
        if (((item != null) && (quantity > 0))) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket - quantity);
            return inBasket;
        }
        return 0;
    }

    public void clearBasket() {
        this.list.clear();
    }

    public Map<CarItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() +
                ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<CarItem, Integer> item : list.entrySet()) {
            s = s + item.getKey().getName() + ". " + item.getValue() + " in basket\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }

    public double getQuantity(String item) {
        for (Map.Entry<CarItem, Integer> entry : list.entrySet()) {
            if (entry.getKey().getName().equals(item)) {
                return entry.getKey().getQuantity();
            }
        }
        return 0;
    }


}
