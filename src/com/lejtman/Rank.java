package com.lejtman;

public enum Rank {

    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getCardString() {
        switch(this.value){
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            case 1 : return "A";
        } 
        return value + "";
}
}
