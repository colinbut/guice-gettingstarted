/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.transaction;

import com.google.inject.Inject;

import java.util.logging.Logger;

public class DatabaseTransactionLog implements TransactionLog {

    private final Logger logger;

    @Inject
    public DatabaseTransactionLog(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void recordTransaction() {
        logger.info("Transaction recorded");
    }

}
