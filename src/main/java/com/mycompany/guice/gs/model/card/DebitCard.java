/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.model.card;

import java.util.Date;

public class DebitCard extends BankCard {

    private String cardNumber;
    private Date expiryDate;
    private int securityCode;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }
}
