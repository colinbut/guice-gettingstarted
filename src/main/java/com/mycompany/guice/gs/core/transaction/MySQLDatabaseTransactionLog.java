/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.transaction;

import com.google.inject.Inject;

import java.util.logging.Logger;

public class MySQLDatabaseTransactionLog extends DatabaseTransactionLog {

    @Inject
    public MySQLDatabaseTransactionLog(Logger logger) {
        super(logger);
    }

}
