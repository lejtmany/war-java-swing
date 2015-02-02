/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lejtman;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author student1
 */
public class Deck{
    
    private final LinkedList<Card> deck;
   
    public Deck(){
        deck = fillDeck();
        this.shuffle();       
    }
    
    public Deck(List<Card> cards){
        deck = new LinkedList<>(cards);
    }

    private LinkedList<Card> fillDeck() {
        LinkedList<Card> cards = new LinkedList<>(); 
        for(Suit suit: Suit.values())
            for(Value value : Value.values())
                cards.add(new Card(suit,value));
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public Card draw(){
        return deck.pop();
    }
    
    public void putCardOnBottom(Card card){
        deck.addFirst(card);
    }
    
    public void putCardOnTop(Card card){
        deck.addLast(card);
    }
    
    public void putCardInPositon(int position, Card card){
        deck.add(position, card);
    }
    
    
}
