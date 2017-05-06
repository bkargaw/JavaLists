/**
 * Created by brukargaw on 5/6/17.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        assertEquals(0, array.size());
    }

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addFirst(1);
        assertEquals(1, array.size());
        array.addFirst(2);
        assertEquals(2, array.size());
        array.addFirst(3);
        assertEquals(3, array.size());
        array.addFirst(4);
        assertEquals(4, array.size());
        array.addFirst(5);
        assertEquals(5, array.size());
    }

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addLast(1);
        assertEquals(1, array.size());
        array.addLast(2);
        assertEquals(2, array.size());
        array.addLast(3);
        assertEquals(3, array.size());
        array.addLast(4);
        assertEquals(4, array.size());
        array.addLast(5);
        assertEquals(5, array.size());
    }

    @Test
    public void testisEmpty(){
        ArrayDeque<Integer> array = new ArrayDeque<>();
        assertTrue(array.isEmpty());
        array.addFirst(1);
        assertFalse(array.isEmpty());
    }

    @Test
    public void testRemoveFirst(){
        ArrayDeque<String> array = new ArrayDeque<>();

        array.addLast("1");
        assertEquals(1, array.size());

        array.addLast("1");
        assertEquals(2, array.size());

        array.removeFirst();
        assertEquals( 1, array.size());

        array.removeFirst();
        assertEquals(0, array.size());
    }

    @Test
    public void testLastFirst(){
        ArrayDeque<String> array = new ArrayDeque<>();

        array.addLast("1");
        assertEquals(1, array.size());

        array.addLast("1");
        assertEquals(2, array.size());

        array.removeLast();
        assertEquals( 1, array.size());

        array.removeLast();
        assertEquals(0, array.size());
    }

    @Test
    public void testGet(){
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addFirst(1);
        assertEquals(1, array.size());

        int actual = array.get(0);
        assertEquals(1 , actual);
        array.addFirst(2);
        array.addFirst(3);
        array.addFirst(4);
        array.addFirst(5);
        array.printDeque();
         actual = array.get(1);
        assertEquals(2, actual);
         actual = array.get(3);
        assertEquals(4 , actual);
         actual = array.get(4);
        assertEquals(5 , actual);

    }

}
