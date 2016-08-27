/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.mycompany.guice.gs.core.payment.PaymentProcessor;
import com.mycompany.guice.gs.core.transaction.TransactionLog;
import com.mycompany.guice.gs.model.OrderItem;
import com.mycompany.guice.gs.model.PizzaOrder;
import com.mycompany.guice.gs.model.Receipt;
import com.mycompany.guice.gs.model.card.BankCard;


public class RealBillingServiceImpl implements BillingService {

    private final PaymentProcessor paymentProcessor;
    private final TransactionLog transactionLog;

    @Named("VAT")
    private String vat;

    /**
     * Constructor Injection
     *
     * @param paymentProcessor
     * @param transactionLog
     */
    @Inject
    public RealBillingServiceImpl(@Named("CardPaymentProcessor") PaymentProcessor paymentProcessor, TransactionLog transactionLog) {
        this.paymentProcessor = paymentProcessor;
        this.transactionLog = transactionLog;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder pizzaOrder, BankCard bankCard) {

        double totalAmount = pizzaOrder.getOrderItems().stream().mapToDouble(OrderItem::getPrice).sum();

        paymentProcessor.pay(totalAmount, bankCard);

        Receipt receipt = new Receipt();
        return receipt;
    }
}
