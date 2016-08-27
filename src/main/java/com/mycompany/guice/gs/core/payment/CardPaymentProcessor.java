/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.payment;

import com.mycompany.guice.gs.model.payment.PaymentMethod;
import com.mycompany.guice.gs.model.payment.card.BankCard;

public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean pay(double amountToPay, PaymentMethod paymentMethod) {

        if (!(paymentMethod instanceof BankCard)) {
            throw new IllegalArgumentException("Invalid payment method passed in");
        }

        return true;
    }
}
