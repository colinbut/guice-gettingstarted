package com.mycompany.guice.gs;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.guice.gs.config.modules.BillingModule;
import com.mycompany.guice.gs.service.BillingService;

public class App {

    public static void main( String[] args ) {
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);
    }
}
