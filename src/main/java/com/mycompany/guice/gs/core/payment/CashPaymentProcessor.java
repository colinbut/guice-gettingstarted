/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.payment;

import com.mycompany.guice.gs.model.payment.Cash;
import com.mycompany.guice.gs.model.payment.PaymentMethod;

public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean pay(double amountToPay, PaymentMethod paymentMethod) {

        if (!(paymentMethod instanceof Cash)) {
            throw new IllegalArgumentException("Invalid payment method passed in");
        }

        return true;
    }
}
