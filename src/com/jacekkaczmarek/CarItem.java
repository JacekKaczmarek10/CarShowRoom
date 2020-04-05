package com.jacekkaczmarek;

public class CarItem implements Comparable<CarItem> {
    private final String name;
    private double price;
    private int quantity = 0;
    private int reserved = 0;

    public CarItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public CarItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public CarItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setReserved(int quantity) {
        this.reserved = this.reserved + quantity;
        System.out.print("U have reserved ");
    }

    public int quantityInStock() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        if (price > 0.0)
            this.price = price;
    }
    public void adjustStock(int quantity){
        int newQuantity = this.quantity + quantity;
        if(newQuantity>=0)
            this.quantity=newQuantity;
        else
            this.quantity=quantity;
    }

    public int finaliseStock(int quantity1) {
        if (quantity1 <= reserved) {
            quantity -= quantity1;
            reserved -= quantity1;
            return quantity1;
        }

        return 0;
    }

    public void decreaseStock(int quantity){
        int newQuantity = this.quantity - quantity;
        if(newQuantity>=0)
            this.quantity=newQuantity;
        else
            this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj==null || (obj.getClass() != this.getClass())) {
            return false;
        }
            String objName = ((CarItem) obj).getName();
            return this.name.equals(objName);
        }

        public int hashCode(){
        return this.name.hashCode() +55;
        }

    @Override
    public int compareTo(CarItem o) {
        if(this == o){
            return 0;
        }
        if(o != null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + "  " + this.price;
    }
}

