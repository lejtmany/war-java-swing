

package com.lejtman;


public class Card {
    public final Value value;
    public final Suit suit;
    
    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }
}
