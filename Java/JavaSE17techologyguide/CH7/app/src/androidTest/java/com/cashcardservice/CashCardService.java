package com.cashcardservice;

public class CashCardService implements Loadable{
    private CashCard[] cashCards;

    public CashCardService(CashCard[] cashCards){
        this.cashCards = cashCards;
    }


    @Override
    public CashCard load(String cardId){
        CashCard cashCard = this.findFirst(cardId);
        if(cashCard == null){
            throw new IllegalArgumentException(String.format("Failed to load. Can not find cardId:%s among these cash cards.%n", cardId));
        }
        return cashCard;
    }

    public boolean contain(String cardId){
        int size = this.cashCards.length;
        for (CashCard cashCard : this.cashCards) {
            if (cashCard.cardId.equals(cardId)) {
                return true;
            }
        }
        return false;
    }

    public CashCard findFirst(String cardId){
        int size = this.cashCards.length;
        for (CashCard cashCard : this.cashCards) {
            if (cashCard.cardId.equals(cardId)) {
                return cashCard;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CashCard[] cashCards = new CashCard[]{
                new CashCard("1", 1000, 0),
                new CashCard("2", 2000, 0),
                new CashCard("3", 3000, 0),
                new CashCard("4", 4000, 0),
                new CashCard("5", 5000, 0)
        };

        CashCardService cashCardService = new CashCardService(cashCards);

    }
}