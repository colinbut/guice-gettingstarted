/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.modules;

import com.google.inject.AbstractModule;
import com.mycompany.guice.gs.core.payment.CreditCardProcessor;
import com.mycompany.guice.gs.core.transaction.DatabaseTransactionLog;
import com.mycompany.guice.gs.core.payment.PaypalCreditCardProcessor;
import com.mycompany.guice.gs.core.transaction.MySQLDatabaseTransactionLog;
import com.mycompany.guice.gs.core.transaction.TransactionLog;

public class BillingModule extends AbstractModule {

    @Override
    protected void configure() {

        // linked bindings
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(DatabaseTransactionLog.class).to(MySQLDatabaseTransactionLog.class); //chaining linked bindings

    }
}
