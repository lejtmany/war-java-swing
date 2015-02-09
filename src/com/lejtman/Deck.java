/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lejtman;

import com.lejtman.Card.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author student1
 */
public class Deck {

    private final LinkedList<Card> deck;

    public Deck() {
        deck = new LinkedList<>();
    }

    public Deck(List<Card> cards) {
        deck = new LinkedList<>(cards);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card draw() {
        return deck.pop();
    }

    public void putCardOnBottom(Card card) {
        deck.addFirst(card);
    }

    public void putCardOnTop(Card card) {
        deck.addLast(card);
    }

    public void putCardInPositon(int position, Card card) {
        deck.add(position, card);
    }

   public static Deck getFullDeck(){
       return new Deck(fillDeck());
   }
   
   private static LinkedList<Card> fillDeck() {
        LinkedList<Card> cards = new LinkedList<>();
        for (Suit suit : Suit.values()) {
            for (Rank value : Rank.values()) {
                cards.add(new Card(suit, value));
            }
        }
        return cards;
    }
    
    public static <T> void shuffle(T[] array) {
        List<T> list = new ArrayList(Arrays.<T>asList(array));
        List<T> shuffledList = shuffleList(list);
        copyListToArray(array, shuffledList);
    }

    private static <T> List<T> shuffleList(List<T> list) {
        List<T> shuffledList = new ArrayList<>();
        Random gen = new Random();
        while (list.size() != 0) {
            T element = takeOutRandomElement(list, gen);
            shuffledList.add(element);
        }
        return shuffledList;
    }

    private static <T> T takeOutRandomElement(List<T> list, Random gen) {
        return list.remove(getRandomIndex(list.size(), gen));
    }

    public static int getRandomIndex(int size, Random gen) {
        return Math.abs(gen.nextInt() % size);
    }

    private static <T> void copyListToArray(T[] array, List<T> list) {
        for (int i = 0; i < array.length; i++) {
            array[i] = list.remove(0);
        }
    }

}
