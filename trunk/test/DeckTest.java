// yosef shalom lejtman

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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

    @Test
    public void testShuffleArray() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] prevShuffle = numbers;
        Integer[] shuffleArray = null;
        int testIterations = 2000;
        int sameCounter = 0;

        for (int i = 0; i < testIterations; i++) {
            shuffleArray = numbers;
            Deck.shuffle(shuffleArray);
            sameCounter = CountSamePositions(prevShuffle, shuffleArray, sameCounter);
            prevShuffle = Arrays.copyOf(shuffleArray, prevShuffle.length);
        }

        assertTrue((sameCounter / testIterations) <= 1);
    }

    private int CountSamePositions(Integer[] prevShuffle, Integer[] shuffleArray, int sameCounter) {
        for (int j = 0; j < prevShuffle.length; j++) {
            if (prevShuffle[j].equals(shuffleArray[j]))
                sameCounter++;
        }
        return sameCounter;
    }
    
    @Test 
    public void testShuffleList(){
        
    }
    
    @Test 
    public void testSplitDeck(){
        Deck deck = Deck.getFullDeck();
        List<Deck> decks = deck.splitDeck(3);
        
    }
            
}
