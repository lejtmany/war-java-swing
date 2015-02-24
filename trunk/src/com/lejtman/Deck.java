//yosef shalom lejtman
package com.lejtman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

    static Random gen;

    static {
        gen = new Random();
    }
    private final LinkedList<Card> deck;

    public Deck() {
        deck = new LinkedList<>();
    }

    public Deck(List<Card> cards) {
        deck = new LinkedList<>(cards);
    }

    public Deck(Deck deck) {
        this(deck.getCards());
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card draw() {
        return deck.pop();
    }

    public Card peekFirst() {
        return deck.peekFirst();
    }

    public void putCardOnBottom(Card card) {
        deck.addFirst(card);
    }

    public void putCardOnTop(Card card) {
        deck.addFirst(card);
    }

    public int size() {
        return deck.size();
    }

    public boolean add(Card c) {
        return deck.add(c);
    }

    public void addCards(Collection<Card> cards) {
        deck.addAll(cards);
    }

    public List<Card> drawAll() {
        ArrayList<Card> cards = new ArrayList<>(deck);
        deck.clear();
        return cards;
    }
    
    public List<Card> asList(){
        return new ArrayList<>(deck);
    }

    public Deck subDeck(int start, int end) {
        List<Card> subList = new ArrayList<>(deck.subList(start, end));
        return new Deck(subList);
    }

    public static Deck getFullDeck() {
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

    public static <T> void shuffle(List<T> list) {
        List<T> shuffledList = shuffleList(list);
        list.clear();
        list.addAll(shuffledList);
    }

    public static <T> List<T> shuffleList(List<T> list) {
        List<T> shuffledList = new ArrayList<>();
        Random gen = new Random();
        while (list.size() != 0) {
            T element = takeOutRandomElement(list);
            shuffledList.add(element);
        }
        return shuffledList;
    }

    private static <T> T takeOutRandomElement(List<T> list) {
        return list.remove(getRandomIndex(list.size()));
    }

    private static int getRandomIndex(int size) {
        return Math.abs(gen.nextInt(size));
    }

    private static <T> void copyListToArray(T[] array, List<T> list) {
        for (int i = 0; i < array.length; i++) {
            array[i] = list.remove(0);
        }
    }

    public void clear() {
        this.clear();
    }

    private List<Card> getCards() {
        return new ArrayList(deck);
    }

}
