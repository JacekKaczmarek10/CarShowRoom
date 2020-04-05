package com.jacekkaczmarek;




import java.util.Map;

public class Main {
    private static CarList carList = new CarList();

    public static void main(String[] args) {
        ///////////////////////////////
        //MAGAZINE PART
        ////////////////////////////
        System.out.println("MAGAZINE PART");


        CarItem temp = new CarItem("Audi A8", 16000, 8);
        carList.addToStock(temp);

        temp = new CarItem("BMW C6", 120000, 6);
        carList.addToStock(temp);

        temp = new CarItem("Audi A8", 160000, -2);
        carList.addToStock(temp);

        temp = new CarItem("Mercedes", 250000, 10);
        carList.addToStock(temp);
        temp = new CarItem("Ford Focus", 80000, 10);
        carList.addToStock(temp);

        temp = new CarItem("Ford Focus", 80000, -11);
        carList.addToStock(temp);

        temp = new CarItem("Skoda Fabia", 70000, 5);
        carList.addToStock(temp);

        temp = new CarItem("Porsche",900000,10);
        carList.addToStock(temp);

        temp = new CarItem("Porsche",900000,-8);
        carList.addToStock(temp);


        System.out.println(carList);
        System.out.println("\n\n\n");


        ///////////////////////////////////
        /////BASKET PART
        ///////////////////////////////////

        Basket jackBasket = new Basket("Jack");

        CarItem item = new CarItem("Ferrari",10,4);
        if(canAdd(item, carList)){
        jackBasket.addToBasket(item,item.getQuantity());}

        item = new CarItem("Skoda Fabia",70000,1);
        if(canAdd(item, carList)){
            jackBasket.addToBasket(item,item.getQuantity());}


        System.out.println(jackBasket);
        System.out.println("\n\n\n");


        //////////////////////////////////////////////////////////////
        ////CHECKOUT PART
        /////////////////////////////////////////////


        checkOut(jackBasket);
        jackBasket.clearBasket();

        Basket sceondBasket = new Basket("Szymon");
        item = new CarItem("Porsche",900000,2);
        if(canAdd(item, carList)){
            sceondBasket.addToBasket(item,item.getQuantity());}

        System.out.println(sceondBasket);
        checkOut(sceondBasket);
        sceondBasket.clearBasket();

        /////////////////////////////////////////
        ////////////////////////////////////////
        ////////////////////////////////////////
        /////////////MAGAZINE PART-CHANGES IN MAGAZIE
        /////////////////////////////////////
        /////////////////////////////////////
        System.out.println("\n\n\n");
        System.out.println("MAGAZIN LIST AT END\n" + carList);
        System.out.println("\n\n\n");
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<CarItem, Integer> item : basket.items().entrySet()) {
            carList.removeFromStock(item.getKey().getName(), item.getValue());
        }
    }




    public static boolean canAdd(CarItem item, CarList carList){
        if(carList.contain(item.getName())) {
            if ( (item.getQuantity() <= carList.get(item.getName()).getQuantity())
            && item.getPrice()==carList.get(item.getName()).getPrice()) {
                return true;
            }
            else
                return false;
        }
        else return false;
    }

    public static boolean canRemove(CarItem item, Basket basket){
        if(basket.contain(item.getName())) {
            if (item.getQuantity() < basket.getQuantity(item.getName())) {
                return true;
            }
            else
                return false;
        }
        else return false;
    }

}
