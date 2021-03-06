package com.example.familyfirst.simpleui;

import com.example.familyfirst.simpleui.DrinkOrder;

import java.util.List;

/**
 * Created by user on 2016/8/10.
 */
public class Order {
    String note;
    String storeInfo;
    List<DrinkOrder> drinkOrderList;

    public int getTotal()
    {
        int total = 0;
        for (DrinkOrder drinkOrder : drinkOrderList)
        {
            total += drinkOrder.lNumber * drinkOrder.drink.getlPrice() + drinkOrder.mNumber * drinkOrder.drink.getmPrice();
        }
        return total;
    }
}

