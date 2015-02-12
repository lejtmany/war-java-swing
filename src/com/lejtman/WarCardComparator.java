
package com.lejtman;

import java.util.Comparator;

/**
 *
 * @author student1
 */
public class WarCardComparator implements Comparator<Card>{

    @Override
    public int compare(Card card1, Card card2) {
        return getCardValue(card1) - getCardValue(card2);
    }

    private int getCardValue(Card card) {
        if(card.getRank() == Rank.ACE)
            return 100;
        else
            return card.getRank().getValue();
    }
    
}
