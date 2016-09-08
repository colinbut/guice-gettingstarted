/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.service;

import com.google.inject.Inject;
import com.mycompany.guice.gs.dao.OrderItemDao;
import com.mycompany.guice.gs.model.OrderItem;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    @Inject
    private OrderItemDao orderItemDao;

    @Override
    public List<OrderItem> getOrderItems() {
        return orderItemDao.getOrderItems();
    }

    @Override
    public OrderItem getOrderItem(int id) {
        return orderItemDao.getOrderItemById(id);
    }

    @Override
    public void placeNewOrder(OrderItem orderItem) {
        orderItemDao.insertOrderItem(orderItem);
    }

}
