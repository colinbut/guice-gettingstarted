/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.config.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.mycompany.guice.gs.config.annotations.Cash;
import com.mycompany.guice.gs.core.payment.CashPaymentProcessor;
import com.mycompany.guice.gs.core.payment.PaymentProcessor;
import com.mycompany.guice.gs.core.transaction.DatabaseTransactionLog;
import com.mycompany.guice.gs.core.payment.CardPaymentProcessor;
import com.mycompany.guice.gs.core.transaction.MySQLDatabaseTransactionLog;
import com.mycompany.guice.gs.core.transaction.TransactionLog;

public class BillingModule extends AbstractModule {

    @Override
    protected void configure() {

        // using binding annotations
        bind(PaymentProcessor.class)
            .annotatedWith(Cash.class)
            .to(CashPaymentProcessor.class); // by default probably take cash from peeps

        // using @Named binding annotation
        bind(PaymentProcessor.class)
            .annotatedWith(Names.named("CardPaymentProcessor"))
            .to(CardPaymentProcessor.class);

        bind(String.class).annotatedWith(Names.named("VAT")).toInstance("25.0%");


        // linked bindings
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(DatabaseTransactionLog.class).to(MySQLDatabaseTransactionLog.class); //chaining linked bindings

    }
}
