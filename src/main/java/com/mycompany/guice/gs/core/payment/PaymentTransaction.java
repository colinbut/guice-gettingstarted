/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.payment;

import com.mycompany.guice.gs.model.PaymentMethod;

public class PaymentTransaction {

    private PaymentType paymentType;
    private PaymentMethod paymentMethod;

    public PaymentTransaction(PaymentType paymentType, PaymentMethod paymentMethod) {
        this.paymentType = paymentType;
        this.paymentMethod = paymentMethod;
    }
}
