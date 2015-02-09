
package com.lejtman;

import java.util.Comparator;

/**
 *
 * @author student1
 */
public class WarCardComparator implements Comparator<Card>{

    @Override
    public int compare(Card card1, Card card2) {
        if(getCardValue(card1) < getCardValue(card2))
            return -1;
        else if(getCardValue(card1) > getCardValue(card2))
            return 1;
        else return 0;
        
    }

    private int getCardValue(Card card) {
        if(card.getRank() == Rank.ACE)
            return Integer.MAX_VALUE;
        else
            return card.getRank().getValue();
    }
    
}
