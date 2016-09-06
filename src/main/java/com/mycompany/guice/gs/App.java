package com.mycompany.guice.gs;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.mycompany.guice.gs.config.modules.BillingModule;
import com.mycompany.guice.gs.model.OrderItem;
import com.mycompany.guice.gs.model.PizzaOrder;
import com.mycompany.guice.gs.model.payment.Cash;
import com.mycompany.guice.gs.model.payment.PaymentMethod;
import com.mycompany.guice.gs.service.BillingService;
import com.mycompany.guice.gs.service.SimpleBillingServiceImpl;

public class App {

    public static void main( String[] args ) {
        Injector injector = Guice.createInjector(new BillingModule(), new JpaPersistModule("myJPAPersistenceUnit"));
        BillingService billingService = injector.getInstance(SimpleBillingServiceImpl.class);

        PizzaOrder pizzaOrder = new PizzaOrder();
        OrderItem orderItem = new OrderItem();
        orderItem.setName("Ham & Pineapple Pizza");
        orderItem.setDescription("Classic Pizza with Ham and Pineapple toppings");
        orderItem.setPrice(5.00);
        pizzaOrder.addOrderItem(orderItem);

        PaymentMethod cashPaymentMethod = new Cash();

        billingService.chargeOrder(pizzaOrder, cashPaymentMethod);
    }
}
