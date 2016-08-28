/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.transaction;

import java.io.File;


public class FileTransactionLog implements TransactionLog {

    private File transactionFile;

    @Override
    public void recordTransaction() {
        // write to transactionFile
    }

    public void setTransactionFile(File transactionFile) {
        this.transactionFile = transactionFile;
    }
}
