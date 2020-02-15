/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;


    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testConstructorFromBadArrays() {
        int number_tries_numbers = 100;
        int number_tries_stars = 40;
        int correct_numbers = 5;
        int correct_stars = 2;
        List<Integer> numbers = new ArrayList<>(Collections.nCopies(number_tries_numbers, 0));
        List<Integer> stars = new ArrayList<>(Collections.nCopies(number_tries_stars, 0));

        for(int n = 0; n < number_tries_numbers; n++)
            for (int s = 0; s < number_tries_stars; s++)
                if (n != correct_numbers && s != correct_stars) {
                    int finalN = n;
                    int finalS = s;
                    assertThrows(IllegalArgumentException.class,
                            () -> new Dip(ListToInt(numbers.subList(0, finalN)), ListToInt(stars.subList(0, finalS))));
                }
    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }


    private int[] ListToInt(List<Integer> x) {
        return x.stream().mapToInt(i -> i).toArray();
    }
}
