/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.dao;

import com.google.inject.Inject;
import com.mycompany.guice.gs.model.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

    private static final String SELECT_ALL_ORDER_ITEMS = "SELECT * FROM order_item";

    @Inject
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderItem> getOrderItems() {
        Query sqlSelectQuery = entityManager.createQuery(SELECT_ALL_ORDER_ITEMS);
        return (List<OrderItem>) sqlSelectQuery.getResultList();
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        return entityManager.find(OrderItem.class, id);
    }

    @Override
    public void insertOrderItem(OrderItem orderItem) {
        entityManager.persist(orderItem);
    }
}
