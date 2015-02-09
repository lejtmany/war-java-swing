

package com.lejtman;


public class Card {

    enum Suit{Hearts,Spades,Diamonds,Clubs};
    
    private final Rank rank;
    private final Suit suit;
    
    public Card(Suit suit, Rank value){
        this.suit = suit;
        this.rank = value;
    }
    
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
    
}
