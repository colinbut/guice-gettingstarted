/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.model.payment.card;

import com.mycompany.guice.gs.model.payment.Bank;
import com.mycompany.guice.gs.model.payment.PaymentMethod;

public abstract class BankCard extends PaymentMethod {

    private Bank bank;
    protected String cardHolderName;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

}
