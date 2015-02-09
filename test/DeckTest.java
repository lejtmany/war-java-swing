/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lejtman.Deck;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author student1
 */
public class DeckTest {
    
    public DeckTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testShuffleList(){
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        Integer[] shuffleArray = null;
        for(int i = 0; i < 2; i++){
            shuffleArray = numbers;
            Deck.shuffle(shuffleArray);
            System.out.println(Arrays.toString(shuffleArray));
        }
          
    }
    
   @Test
    public void testGetRandomIndex(){
        int size = 15;
        boolean valid = true;
        Random gen = new Random();
        List<Integer> randomIndexes = new ArrayList();
        for(int i = 0; i < 1000; i++)
           randomIndexes.add(Deck.getRandomIndex(15, gen));
        for(int i : randomIndexes)
            if(i < 0 || i > size - 1)
                valid = false;        
        assertTrue(valid);
    }
}
