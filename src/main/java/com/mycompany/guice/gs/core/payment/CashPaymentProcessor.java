/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.payment;

import com.google.inject.Inject;
import com.mycompany.guice.gs.model.payment.Cash;
import com.mycompany.guice.gs.model.payment.PaymentMethod;

import java.util.logging.Logger;

public class CashPaymentProcessor implements PaymentProcessor {

    private final Logger logger;

    @Inject
    public CashPaymentProcessor(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean pay(double amountToPay, PaymentMethod paymentMethod) {

        logger.info("Paying");

        if (!(paymentMethod instanceof Cash)) {
            throw new IllegalArgumentException("Invalid payment method passed in");
        }

        logger.info("Paid");

        return true;
    }
}
