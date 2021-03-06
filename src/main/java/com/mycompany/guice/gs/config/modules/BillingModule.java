/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.config.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.mycompany.guice.gs.config.annotations.CashPayment;
import com.mycompany.guice.gs.config.annotations.FileTransaction;
import com.mycompany.guice.gs.core.OrderCostCalculator;
import com.mycompany.guice.gs.core.payment.CashPaymentProcessor;
import com.mycompany.guice.gs.core.payment.PaymentProcessor;
import com.mycompany.guice.gs.core.transaction.DatabaseTransactionLog;
import com.mycompany.guice.gs.core.payment.CardPaymentProcessor;
import com.mycompany.guice.gs.core.transaction.FileTransactionLog;
import com.mycompany.guice.gs.core.transaction.MySQLDatabaseTransactionLog;
import com.mycompany.guice.gs.core.transaction.TransactionLog;

import java.io.File;

public class BillingModule extends AbstractModule {

    @Override
    protected void configure() {

        // using binding annotations
        bind(PaymentProcessor.class)
            .annotatedWith(CashPayment.class)
            .to(CashPaymentProcessor.class); // by default probably take cash from peeps

        // using @Named binding annotation
        bind(PaymentProcessor.class)
            .annotatedWith(Names.named("CardPaymentProcessor"))
            .to(CardPaymentProcessor.class);

        // instance bindings
        bind(Double.class).annotatedWith(Names.named("VAT")).toInstance(25.0); // 25% vat yeah?
        bind(Double.class).annotatedWith(Names.named("SERVICE_CHARGE")).toInstance(12.5); // 12.5% service charge yeah?

        // linked bindings
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(DatabaseTransactionLog.class).to(MySQLDatabaseTransactionLog.class); //chaining linked bindings

        // untargeted bindings
        bind(OrderCostCalculator.class).in(Singleton.class); // bind concrete classes

    }

    @Provides
    @FileTransaction
    TransactionLog provideFileTransactionLog() {
        FileTransactionLog fileTransactionLog = new FileTransactionLog();
        fileTransactionLog.setTransactionFile(new File("transactionfile.log"));
        return fileTransactionLog;
    }
}
