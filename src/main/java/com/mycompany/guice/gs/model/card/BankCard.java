/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.model.card;

import com.mycompany.guice.gs.model.Bank;
import com.mycompany.guice.gs.model.PaymentMethod;

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
