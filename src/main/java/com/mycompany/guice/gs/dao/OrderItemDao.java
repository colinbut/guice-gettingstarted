/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.dao;

import com.mycompany.guice.gs.model.OrderItem;

import java.util.List;

public interface OrderItemDao {

    List<OrderItem> getOrderItems();

    OrderItem getOrderItemById(int id);

    void insertOrderItem(OrderItem orderItem);
}
