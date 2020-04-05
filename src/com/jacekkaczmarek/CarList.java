package com.jacekkaczmarek;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarList {
    private final Map<String, CarItem> list;

    public CarList() {
        this.list = new LinkedHashMap<>();
    }

    public Map<String , Double> PriceList(){
        Map<String,Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, CarItem> item: list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public int modifyStock(CarItem item){
        if(item!=null) {
            CarItem instock = list.getOrDefault(item.getName(), item);
            if (instock != item){
                instock.setQuantity(instock.quantityInStock());
            }
            if(instock.quantityInStock()<0){
                instock.setQuantity(0);
            }
            list.put(item.getName(),item);
            return item.quantityInStock();
        }
        return 0;
    }


    public boolean contain(String name){
        for (Map.Entry<String, CarItem> entry : list.entrySet()){
            if(entry.getKey().equals(name))return true;
        }
        return false;
    }

    public int addToStock(CarItem item){
        if(item!=null) {
            CarItem instock = list.getOrDefault(item.getName(), item);
            if (instock != item){
                item.adjustStock(instock.quantityInStock());
            }
            if(instock.quantityInStock()<0){
                instock.setQuantity(0);
            }
            list.put(item.getName(),item);
            return item.quantityInStock();
        }
        return 0;
    }


    public int removeFromStock(String item,int quantity){
        CarItem inStock = list.get(item);
        if((inStock != null) && (quantity > 0)) {
            list.get(item).setQuantity(list.get(item).quantityInStock()-quantity);
        }
        return 0;
    }

    public CarItem get(String key){
        return list.get(key);
    }

    public Map<String , CarItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s ="\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String , CarItem> item: list.entrySet()){
            CarItem carItem = item.getValue();

            double itemValue = carItem.getPrice() * carItem.quantityInStock();

            s = s + carItem + ". There are " + carItem.quantityInStock() + "in stock. Value of items ";
            s = s + itemValue + "\n";
            totalCost +=itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
