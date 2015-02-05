

package com.lejtman;


public class Card {
    public final Rank value;
    public final Suit suit;
    
    public Card(Suit suit, Rank value){
        this.suit = suit;
        this.value = value;
    }
}
