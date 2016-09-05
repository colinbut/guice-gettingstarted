/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Receipt {

    private PizzaOrder pizzaOrder;
    private double vatAmount;
    private double totalAmount;
    private double paidAmount;
    private double changeBack;

    public double getChangeBack() {
        return changeBack;
    }

    public void setChangeBack(double changeBack) {
        this.changeBack = changeBack;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Receipt receipt = (Receipt) o;

        return new EqualsBuilder()
            .append(vatAmount, receipt.vatAmount)
            .append(totalAmount, receipt.totalAmount)
            .append(paidAmount, receipt.paidAmount)
            .append(changeBack, receipt.changeBack)
            .append(pizzaOrder, receipt.pizzaOrder)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(pizzaOrder)
            .append(vatAmount)
            .append(totalAmount)
            .append(paidAmount)
            .append(changeBack)
            .toHashCode();
    }
}
