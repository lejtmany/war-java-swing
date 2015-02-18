

package com.lejtman;


public class Card implements Comparable<Card>{

    
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
    
    @Override
    public int compareTo(Card that) {
        int cmp = this.rank.getValue() - that.rank.getValue();
        if(cmp != 0)
            return cmp;
        return this.suit.compareTo(that.suit);
    }
    
    @Override
    public String toString(){
        return String.format("%s of %s", rank, suit);
    }
    
}
