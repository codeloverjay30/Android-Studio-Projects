package com.cashcardservice;

public class CashCard {
    String cardId;
    int balance;
    int bonus;

    public CashCard(String cardId,int balance,int bonus){
        this.cardId = cardId;
        this.balance = balance;
        this.bonus = bonus;
    }
}
