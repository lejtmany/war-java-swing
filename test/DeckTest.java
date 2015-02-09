// yosef shalom lejtman
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

    @Test
    public void testShuffleList() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] prevShuffle = numbers;
        Integer[] shuffleArray = null;
        int testIterations = 2000;
        int sameCounter = 0;

        for (int i = 0; i < testIterations; i++) {
            shuffleArray = numbers;
            Deck.shuffle(shuffleArray);
            for (int j = 0; j < prevShuffle.length; j++) {
                if (prevShuffle[j].equals(shuffleArray[j])) 
                    sameCounter++;               
            }
            prevShuffle = Arrays.copyOf(shuffleArray, prevShuffle.length);
        }

        assertTrue((sameCounter / testIterations) <= 1);
    }

    @Test
    public void testGetRandomIndex() {
        int size = 15;
        boolean valid = true;
        Random gen = new Random();
        List<Integer> randomIndexes = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            randomIndexes.add(Deck.getRandomIndex(15, gen));
        }
        for (int i : randomIndexes) {
            if (i < 0 || i > size - 1) {
                valid = false;
            }
        }
        assertTrue(valid);
    }
}
