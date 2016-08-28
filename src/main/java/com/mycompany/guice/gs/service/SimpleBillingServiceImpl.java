/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.service;

import com.google.inject.Inject;
import com.mycompany.guice.gs.config.annotations.CashPayment;
import com.mycompany.guice.gs.config.annotations.FileTransaction;
import com.mycompany.guice.gs.core.payment.PaymentProcessor;
import com.mycompany.guice.gs.core.transaction.TransactionLog;
import com.mycompany.guice.gs.model.OrderItem;
import com.mycompany.guice.gs.model.payment.Cash;
import com.mycompany.guice.gs.model.payment.PaymentMethod;
import com.mycompany.guice.gs.model.PizzaOrder;
import com.mycompany.guice.gs.model.Receipt;

import java.util.logging.Logger;

public class SimpleBillingServiceImpl implements BillingService {

    private final Logger logger;

    private final PaymentProcessor paymentProcessor;
    private final TransactionLog transactionLog;

    @Inject
    public SimpleBillingServiceImpl(@CashPayment PaymentProcessor paymentProcessor,
                                    @FileTransaction TransactionLog transactionLog,
                                    Logger logger) {
        this.paymentProcessor = paymentProcessor;
        this.transactionLog = transactionLog;
        this.logger = logger;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder pizzaOrder, PaymentMethod paymentMethod) {

        logger.info("Charging order");

        if (!(paymentMethod instanceof Cash)) {
            throw new IllegalStateException("Incorrect payment method passed in");
        }

        logger.fine("Calculating total amount to be paid");
        double totalAmount = pizzaOrder.getOrderItems().stream().mapToDouble(OrderItem::getPrice).sum();

        logger.info("Paying " + totalAmount + " with " + paymentMethod);
        if (paymentProcessor.pay(totalAmount, paymentMethod)) {
            transactionLog.recordTransaction();
        }

        Receipt receipt = new Receipt();
        return receipt;
    }
}
