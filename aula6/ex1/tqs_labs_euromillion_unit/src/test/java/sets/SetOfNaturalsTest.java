/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.Random;

/**
 * @author ico0
 */
public class SetOfNaturalsTest {
    private SetOfNaturals setA;
    private SetOfNaturals setB;
    private SetOfNaturals setC;
    private SetOfNaturals setD;

    /****** TESTS ******/
    /*
      * Verify if when we add a new element, verify if the size is what is expected
        and if the elements added are on the set
      * Test if the sets does throw a error when added a negative number
      * Verify if two sets with no common elements have no intersection
      * Test if it is possible to add the same number multiple times (and if a error is thrown)
      * Test if the set contains a number that wasn't added
      * Test if two sets with the same added numbers are equal to each other
      * Test if two sets with different added numbers are, in fact, different
    */


    @BeforeEach
    public void setUp() {
        setA = new SetOfNaturals();
        setB = SetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});

        setC = new SetOfNaturals();
        for (int i = 5; i < 50; i++) {
            setC.add(i * 10);
        }
        setD = SetOfNaturals.fromArray(new int[]{30, 40, 50, 60, 10, 20});
    }

    @AfterEach
    public void tearDown() {
        setA = setB = setC = setD = null;
    }

    @Test
    public void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        setB.add(11);
        assertTrue(setB.contains(11), "add: added element not found in set.");
        assertEquals(7, setB.size(), "add: elements count not as expected.");
    }

    @Test
    public void testAddBadArray() {
        int[] elems = new int[]{10, 20, -30};

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));
    }


    @Test
    public void testIntersectForNoIntersection() {
        assertFalse(setA.intersects(setB), "no intersection but was reported as existing");
    }

    @Test
    public void testAddSameMultiple() {
        int n = (new Random()).nextInt(10000);
        setA.add(n);
        assertThrows(IllegalArgumentException.class, () -> setA.add(n), "Number " + n + "added multiple times");
    }

    @Test
    public void testSetContainsNumberNotAdded() {
        for (int i = 0; i < 1000; i++)
            assertFalse(setA.contains(i), "Set A contains number " + i + "but this wasn't added");
    }

    @Test
    public void testEqualSets() {
        int max_numbers = 100;

        setB = new SetOfNaturals();
        for (int i = 1; i < max_numbers; i++) {
            setA.add(i);
            setB.add(i);
        }

        assertEquals(setA, setB, "setA and setB had the same numbers added, but are not equal");
    }

    @Test
    public void testDifferentSets() {
        assertNotEquals(setB, setD, "setB and setD are different, but equals() method returned true");
    }
}
