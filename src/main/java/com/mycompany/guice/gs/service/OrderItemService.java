/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.service;

import com.mycompany.guice.gs.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getOrderItems();

    OrderItem getOrderItem(int id);

    void placeNewOrder(OrderItem orderItem);

}
