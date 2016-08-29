/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.mycompany.guice.gs.model.OrderItem;

import java.util.List;

@Singleton
public final class OrderCostCalculator {

    private Double vat;
    private Double serviceCharge;

    /**
     * Setter Injection in example
     *
     * @param vat
     */
    @Inject
    public void setVat(@Named("VAT") Double vat) {
        this.vat = vat;
    }

    @Inject
    public void setServiceCharge(@Named("SERVICE_CHARGE") Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }


    public double calculate(List<OrderItem> orders) {
        // order total
        double totalAmount = orders.stream().mapToDouble(OrderItem::getPrice).sum();

        // add VAT
        totalAmount += totalAmount * (vat / 100);

        // add service charge :)
        totalAmount += totalAmount * (serviceCharge / 100);

        return totalAmount;
    }
}
