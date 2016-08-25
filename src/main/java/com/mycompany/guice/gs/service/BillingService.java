/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.service;

import com.mycompany.guice.gs.model.PizzaOrder;
import com.mycompany.guice.gs.model.Receipt;
import com.mycompany.guice.gs.model.card.BankCard;


public interface BillingService {

    Receipt chargeOrder(PizzaOrder pizzaOrder, BankCard bankCard);

}
