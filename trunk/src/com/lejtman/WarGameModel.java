//yosef shalom lejtman
package com.lejtman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarGameModel {

    private final Deck[] players;
    private final Deck[] pool;
    private boolean gameOver = false;
    private final WarCardComparator comparator;

    public WarGameModel() {
        this.comparator = new WarCardComparator();
        Deck deck = Deck.getFullDeck();
        deck.shuffle();
        this.players = splitDeck(deck);
        pool = initializePool();
    }

    private Deck[] initializePool() {
        Deck[] deckArray = new Deck[2];
        for (int i = 0; i < 2; i++) {
            deckArray[i] = new Deck();
        }
        return deckArray;
    }


    public String move() {
        if(isGameOver())
            return "Game Over";
        for (int i = 0; i < players.length; i++) {
            pool[i].putCardOnTop(players[i].draw());
        }
        int winner = getWinningIndex();
        while (winner == -1) {
            war();
            winner = getWinningIndex();
        }
        String moveString = moveToString(winner);
        giveWinnerCards(winner);
        checkInvariants();
        checkGameOver();
        return moveString;
    }

    public int getWinningIndex() {
        int comp = comparator.compare(pool[0].peekFirst(), pool[1].peekFirst());
        if (comp < 0) {
            return 1;
        } else if (comp > 0) {
            return 0;
        } else {
            return -1;
        }
    }

    private void giveWinnerCards(int winningIndex) {
        List<Card> wholePool = new ArrayList<>(pool[(winningIndex == 0) ? 1 : 0].drawAll());
        pool[winningIndex].addCards(wholePool);
        pool[winningIndex].shuffle();
        players[winningIndex].addCards(pool[winningIndex].drawAll());
    }
    
      private String moveToString(int winner) {
          return String.format("%s %20s %20s %20d %20d %20d", pool[0].peekFirst().toString(), pool[1].peekFirst().toString(), "Player " + (winner + 1), players[0].size(), players[1].size(), pool[0].size() + pool[1].size());
    }

    private String printCounts() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= players.length; i++) {
            sb.append(String.format("Player %d: %d", i, players[i].size()));
        }
        return sb.toString();
    }

    private void war() {
        for (int i = 0; i < pool.length; i++) {
            tryDrawNCards(i, 4);
        }
    }

    private void tryDrawNCards(int index, int amtOfCards) {
        for (int i = 0; i < amtOfCards; i++) {
            tryDrawCard(index);
        }
    }

    private void tryDrawCard(Integer index) {
        if (players[index].size() != 0) {
            pool[index].putCardOnTop(players[index].draw());
        }
    }

    private Deck[] splitDeck(Deck deck) {
        Deck[] deckArray = new Deck[2];
        deckArray[0] = deck.subDeck(0, deck.size() / 2);
        deckArray[1] = deck.subDeck(deck.size() / 2, deck.size());
        return deckArray;
    }


    private void checkGameOver() {
        for(Deck deck : players)
            if(deck.size() == 0)
                gameOver = true;
    }

    private void checkInvariants() {
        assert(players[0].size() + players[1].size() == 52);
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

  

}
