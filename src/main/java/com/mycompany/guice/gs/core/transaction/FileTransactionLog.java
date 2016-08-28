/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.transaction;

import com.google.inject.Inject;

import java.io.File;
import java.util.logging.Logger;

public class FileTransactionLog implements TransactionLog {

    private final Logger logger;
    private File transactionFile;

    @Inject
    public FileTransactionLog(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void recordTransaction() {
        // write to transactionFile
        logger.info("Recorded transaction");
    }

    public void setTransactionFile(File transactionFile) {
        this.transactionFile = transactionFile;
    }
}
