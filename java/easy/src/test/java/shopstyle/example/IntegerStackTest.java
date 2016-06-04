package shopstyle.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

public class IntegerStackTest {

    private Stack<Integer> stack;

    @Before
    public void setup(){
        stack = new IntegerStack();
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        assertTrue("stack should be empty", stack.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNonEmpty() {
        stack.push(0);
        assertFalse("should not be empty", stack.isEmpty());
    }

    @Test
    public void testPeekWhenEmpty() {
        assertFalse("should return an empty optional", stack.peek().isPresent());
    }

    @Test
    public void testPeekWhenNonEmpty() {
        stack.push(0);
        assertEquals("should return the most recently pushed entry", Integer.valueOf(0),
                stack.peek().get());
    }

    @Test
    public void testPeekNonMutating() {
        stack.push(0);
        stack.peek();
        assertFalse("peek should not mutate the stack", stack.isEmpty());
    }

    @Test
    public void testPopWhenEmpty() {
        assertFalse("should return an empty optional", stack.pop().isPresent());
    }

    @Test
    public void testPopWhenNonEmpty() {
        stack.push(0);
        assertEquals("should return the most recently pushed entry", Integer.valueOf(0),
                stack.pop().get());
    }

    @Test
    public void testPopRemovesEntry() {
        stack.push(0);
        stack.pop();
        assertTrue("pop should remove an entry", stack.isEmpty());
    }

    @Test
    public void pushHappyPath() {
        stack.push(0);
        assertFalse("push should add an entry", stack.isEmpty());
    }


    @Test (expected = IllegalArgumentException.class)
    public void pushExceedsCapacity() {
        int size = 2;
        stack = new IntegerStack(size);
        for (int i=0; i<= size; i++){
            stack.push(i);
        }
    }


}