package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
    }

    @Test
    public void testEnqueueDequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);

        for (int i = 10; i < arb.capacity(); i -= 1) {
            arb.enqueue(i);
        }

        for (int i = 10; i < arb.capacity(); i -= 1) {
            assertEquals((int) arb.dequeue(), i);
        }
    }


    @Test
    public void testPeek() {
        BoundedQueue<Integer> arb = new ArrayRingBuffer<>(10);

        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.enqueue(i);
        }

        for (int i = 0; i < 5; i += 1) {
            arb.dequeue();
        }

        assertEquals((int) arb.peek(), 5);
    }

    @Test
    public void testIsFull() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);

        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.enqueue(i);
        }

        assertTrue(arb.isFull());
    }


    @Test
    public void testIsEmpty() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);

        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.enqueue(i);
        }
        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.dequeue();
        }

        assertTrue(arb.isEmpty());
    }

    /* Make sure it throws Exception
    @Test
    public void testThrowException() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);

        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.enqueue(i);
        }

        arb.enqueue(666);   // java.lang.RuntimeException: Ring buffer overflow

        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.dequeue();
        }

        arb.dequeue();      // java.lang.RuntimeException: Ring buffer underflow
        arb.peek();         // java.lang.RuntimeException: Ring buffer underflow

    }
    */


    @Test
    public void testIterator() {
        BoundedQueue<Integer> arb = new ArrayRingBuffer<>(10);

        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.enqueue(i * 2);
        }

        /* Test
        ArrayRingBuffer.BufferIterator iterator = arb.new BufferIterator();

        Iterator iterator = arb.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        */

        // Nested Iterator test
        for (int x : arb) {
            for (int y : arb) {
                System.out.println("x: " + x + "; y: " + y);
            }
        }

    }


    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
