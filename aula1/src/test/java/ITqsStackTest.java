import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tqsua.lab1stack.ITqsStack;

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
        for(int i = 0; i < expected_final_size; i++)
            this.test_stack.push(i);

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
        Assertions.assertEquals( x, this.test_stack.pop());
    }

    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
}
