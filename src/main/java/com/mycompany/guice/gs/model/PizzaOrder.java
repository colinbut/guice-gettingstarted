/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {

    private List<OrderItem> orderItems;

    public PizzaOrder() {
        orderItems = new ArrayList<>();
    }

    public List<OrderItem> getOrderItems() {
        return new ArrayList<>(orderItems);
    }
}
