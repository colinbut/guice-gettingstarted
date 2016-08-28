/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.payment;

import com.google.inject.Inject;
import com.mycompany.guice.gs.model.payment.PaymentMethod;
import com.mycompany.guice.gs.model.payment.card.BankCard;

import java.util.logging.Logger;

public class CardPaymentProcessor implements PaymentProcessor {

    private final Logger logger;

    @Inject
    public CardPaymentProcessor(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean pay(double amountToPay, PaymentMethod paymentMethod) {

        logger.info("Paying");

        if (!(paymentMethod instanceof BankCard)) {
            throw new IllegalArgumentException("Invalid payment method passed in");
        }

        logger.info("Paid");

        return true;
    }
}
