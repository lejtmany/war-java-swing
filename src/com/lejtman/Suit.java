//yosef shalom lejtman
package com.lejtman;

public enum Suit {

    Hearts, Spades, Diamonds, Clubs;

    public String getCardString() {
        switch(this){
            case Spades: return "\u2660";
            case Hearts: return "\u2665";
            case Diamonds: return "\u2666";
            case Clubs: return "\u2663";
        }      
        return "ERROR";
    }
}
