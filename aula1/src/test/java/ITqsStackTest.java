import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;
import tqsua.lab1stack.ITqsStack;

import java.util.NoSuchElementException;

public class ITqsStackTest {

    private ITqsStack<Integer> test_stack;

    public ITqsStackTest() {
        test_stack = new ITqsStack<Integer>();
    }


    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }

    // @Tag("DEV")
    // TODO -> ver o que significam estas tags
    @Test
    void testInitEmpty()
    {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals( true, this.test_stack.isEmpty());
    }

    @Tag("PROD")
    @Test
    void testInitSize()
    {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals( 0, this.test_stack.size());
    }

    @Test
    void testPushSize()
    {
        System.out.println("======TEST THREE EXECUTED=======");

        int expected_final_size = 100;
        this.pushN(expected_final_size);

        Assertions.assertEquals( false, this.test_stack.isEmpty());
        Assertions.assertEquals( expected_final_size, this.test_stack.size());
    }

    @Tag("PROD")
    @Test
    void testPushThenPop()
    {
        System.out.println("======TEST FOUR EXECUTED=======");

        int x = (int)(Math.random()*10000);
        this.test_stack.push(x);
        Assertions.assertEquals(x, this.test_stack.pop());
    }

    @Test
    void testPushThenPeek() {
        System.out.println("======TEST FIVE EXECUTED======");

        int x = (int)(Math.random()*10000);
        this.test_stack.push(x);
        Assertions.assertEquals(x, this.test_stack.peek());
    }

    @Test
    void testPushNPopN() {
        System.out.println("======TEST SIX EXECUTED======");

        int n = 100;
        this.test_stack.clear();

        this.pushN(n);
        this.popN(n);

        Assertions.assertEquals(true, this.test_stack.isEmpty());
        Assertions.assertEquals(0, this.test_stack.size());
    }

    @Test
    void testPopEmpty() {
        System.out.println("======TEST SIX EXECUTED======");

        this.test_stack.clear();
        Assertions.assertThrows(NoSuchElementException.class, () -> ITqsStackTest.this.test_stack.pop());
    }

    @Test
    void testPeekEmpty() {
        System.out.println("======TEST SEVEN EXECUTED======");

        this.test_stack.clear();
        Assertions.assertThrows(NoSuchElementException.class, () -> ITqsStackTest.this.test_stack.peek());
    }

    @Test
    void testFullBoundedStack() {
        System.out.println("======TEST EIGHT EXECUTED======");

        int max_size = 100;
        this.test_stack.clear();
        this.test_stack.defineMaxSize(max_size);

        for (int i = 0; i < max_size; i++)
            this.test_stack.push(i);
        Assertions.assertThrows(IllegalStateException.class, () -> ITqsStackTest.this.test_stack.push(0));
    }

    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }

    private void pushN(int n) {
        for(int i = 0; i < n; i++)
            this.test_stack.push(i);
    }

    private void popN(int n) {
        for(int i = 0; i < n; i++)
            this.test_stack.pop();
    }
}
