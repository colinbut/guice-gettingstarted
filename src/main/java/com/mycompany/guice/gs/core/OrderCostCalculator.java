/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core;

import com.google.inject.Singleton;
import com.mycompany.guice.gs.model.OrderItem;

import java.util.List;

@Singleton
public final class OrderCostCalculator {

    public double calculate(List<OrderItem> orders) {
        double totalAmount = orders.stream().mapToDouble(OrderItem::getPrice).sum();
        return totalAmount;
    }
}
