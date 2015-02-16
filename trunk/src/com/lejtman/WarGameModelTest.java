package com.lejtman;

import junit.framework.TestCase;
import static org.assertj.core.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WarGameModelTest{

    public WarGameModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetWinningIndexFindsWinner() {
        WarGameModel model = new WarGameModel();
        model.setPool(createPool(new Card(Card.Suit.Clubs, Rank.ACE), new Card(Card.Suit.Clubs, Rank.KING)));
        assertThat(model.getWinningIndex()).isEqualTo(0);
    }

    @Test
    public void testGetWinningIndexFindsTie() {
        WarGameModel model = new WarGameModel();
        model.setPool(createPool(new Card(Card.Suit.Clubs, Rank.ACE), new Card(Card.Suit.Clubs, Rank.ACE)));
        assertThat(model.getWinningIndex()).isEqualTo(-1);
    }
    
    @Test 
    public void testEachDrawWhenEnoughCards(){
        WarGameModel model = new WarGameModel();
        Deck[] preDraw = model.getPlayers();
        model.eachDraw(4);
        Deck[] postDraw = model.getPlayers();
        assertThat(preDraw[0].size() - postDraw[0].size()).isEqualTo(4);
    }
    
    @Test 
    public void testEachDrawWhenNotEnoughCards(){
        WarGameModel model = new WarGameModel();
        Deck[] preDraw = model.getPlayers();
        model.eachDraw(27);
        Deck[] postDraw = model.getPlayers();
        assertThat(preDraw[0].size() - postDraw[0].size()).isEqualTo(26);
    }

    private Deck[] createPool(Card card1, Card card2) {
        Deck player1 = new Deck();
        player1.add(card1);
        Deck player2 = new Deck();
        player2.add(card2);
        Deck[] pool = {player1, player2};
        return pool;
    }
}
