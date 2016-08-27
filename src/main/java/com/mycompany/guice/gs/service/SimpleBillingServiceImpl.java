/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.service;

import com.google.inject.Inject;
import com.mycompany.guice.gs.config.annotations.Cash;
import com.mycompany.guice.gs.core.payment.PaymentProcessor;
import com.mycompany.guice.gs.core.transaction.TransactionLog;
import com.mycompany.guice.gs.model.PizzaOrder;
import com.mycompany.guice.gs.model.Receipt;
import com.mycompany.guice.gs.model.card.BankCard;

public class SimpleBillingServiceImpl implements BillingService {

    private final PaymentProcessor paymentProcessor;
    private final TransactionLog transactionLog;

    @Inject
    public SimpleBillingServiceImpl(@Cash PaymentProcessor paymentProcessor, TransactionLog transactionLog) {
        this.paymentProcessor = paymentProcessor;
        this.transactionLog = transactionLog;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder pizzaOrder, BankCard bankCard) {
        return null;
    }
}
