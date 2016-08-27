/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.payment;

import com.mycompany.guice.gs.model.PaymentMethod;

public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean pay(double amountToPay, PaymentMethod paymentMethod) {
        return false;
    }
}
