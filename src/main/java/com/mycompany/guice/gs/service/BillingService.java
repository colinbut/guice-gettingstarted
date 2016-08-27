/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.service;

import com.mycompany.guice.gs.model.payment.PaymentMethod;
import com.mycompany.guice.gs.model.PizzaOrder;
import com.mycompany.guice.gs.model.Receipt;


public interface BillingService {

    Receipt chargeOrder(PizzaOrder pizzaOrder, PaymentMethod paymentMethod);

}
