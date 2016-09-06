/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.config;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;


public class Initializer {

    @Inject
    Initializer(PersistService persistService) {
        persistService.start();
    }

}
