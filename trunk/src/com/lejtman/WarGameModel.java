//yosef shalom lejtman
package com.lejtman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarGameModel {

    private List<Deck> players;
    private List<Deck> pool;
    private final int numOfPlayers;
    private boolean gameOver = false;

    public WarGameModel(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        Deck deck = Deck.getFullDeck();
        this.players = deck.splitDeck(numOfPlayers);
        pool = new ArrayList<>();
        mainLoop();
    }

    private void mainLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any key to for move. Enter q to quit.");
        printHeaders();
        while (!scanner.next().equals("q")) {
            int winner = move();
            printMove(winner);
        }
    }

    private int move() {
        for (int i = 0; i < players.size(); i++) {
            pool.get(i).putCardOnTop(players.get(i).draw());
        }
        List<Integer> winningIndexes = findWinningIndex();
        if (winningIndexes.size() != 1) {
            war(winningIndexes);
            move();
            removeOutPlayers();
            checkGameOver();
        }
        for(Deck deck : pool)
            deck.clear();
        return winningIndexes.get(0);
    }

    private void printHeaders() {
        System.out.println("");
    }

    private void printMove(int winner) {
        System.out.println(moveToString(winner));
    }

    private String moveToString(int winner) {
        return printCards() + printWinner(winner) + printCounts();

    }

    private String printWinner(int winner) {
        return pool.get(winner).peekFirst().toString();
    }

    private String printCards() {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= players.size(); i++)
            sb.append(String.format("Player %d: %s", i, pool.get(i).peekFirst().toString()));
        return sb.toString();
    }

    private String printCounts() {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= players.size(); i++)
            sb.append(String.format("Player %d: %d", i, players.get(i).size()));
        return sb.toString();
    }

    /**
     * @return the numOfPlayers
     */
    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    private List<Integer> findWinningIndex() {
        List<Integer> indexes = new ArrayList<>();
        Card maxCard = pool.get(0).peekFirst();
        indexes.add(0);
        for (int i = 1; i < pool.size(); i++) {
            if (maxCard.compareTo(pool.get(i).peekFirst()) < 0) {
                indexes.clear();
                indexes.add(i);
                maxCard = pool.get(i).peekFirst();
            } else if (maxCard.compareTo(pool.get(i).peekFirst()) == 0) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private void war(List<Integer> winningIndexes) {
        for (Integer index : winningIndexes) {
            tryDrawThreeCards(index);
        }
    }

    private void tryDrawThreeCards(Integer index) {
        for (int i = 0; i < 3; i++) {
            tryDrawCard(index);
        }
    }

    private void tryDrawCard(Integer index) {
        if (players.get(index).size() != 0) {
            pool.get(index).putCardOnTop(players.get(index).draw());
        }
    }

    private void removeOutPlayers() {
        for(int i = 0; i < players.size(); i++)
            if(players.get(i).size() == 0){
                players.remove(i);
                pool.remove(i);
            }
    }

    private void checkGameOver() {
        if(players.size() <= 1)
            gameOver = true;
    }

}
