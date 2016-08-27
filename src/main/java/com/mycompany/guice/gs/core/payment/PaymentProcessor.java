/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.core.payment;

import com.mycompany.guice.gs.model.payment.PaymentMethod;

public interface PaymentProcessor {

    boolean pay(double amountToPay, PaymentMethod paymentMethod);

}
