/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.guice.gs.model.payment.card;

import com.mycompany.guice.gs.model.payment.Bank;
import com.mycompany.guice.gs.model.payment.PaymentMethod;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BankCard bankCard = (BankCard) o;

        return new EqualsBuilder()
            .append(bank, bankCard.bank)
            .append(cardHolderName, bankCard.cardHolderName)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(bank)
            .append(cardHolderName)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("bank", bank)
            .append("cardHolderName", cardHolderName)
            .toString();
    }
}
