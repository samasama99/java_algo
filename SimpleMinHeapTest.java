import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleMinHeapTest {

    @Test
    public void testAddAll() {
        SimpleMinHeap<Integer> simpleMinHeap = new SimpleMinHeap<>();

        List<Integer> elementsToAdd = Arrays.asList(4, 1, 7, 9, 2);

        simpleMinHeap.addAll(elementsToAdd);

        // Check if elements in 'arr' are in ascending order
        for (int i = 0; i < simpleMinHeap.arr.size() - 1; i++) {
            Assertions.assertTrue(simpleMinHeap.arr.get(i).compareTo(simpleMinHeap.arr.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testAddZeroElements() {
        SimpleMinHeap<Integer> simpleMinHeap = new SimpleMinHeap<>();
        Assertions.assertTrue(simpleMinHeap.arr.isEmpty());
    }

    @Test
    public void testAddOneElement() {
        SimpleMinHeap<Integer> simpleMinHeap = new SimpleMinHeap<>();
        simpleMinHeap.add(42);
        Assertions.assertTrue(simpleMinHeap.arr.size() == 1 && simpleMinHeap.arr.get(0) == 42);
    }

    @Test
    public void testAddTenElements() {
        SimpleMinHeap<Integer> simpleMinHeap = new SimpleMinHeap<>();
        for (int i = 1; i <= 10; i++) {
            simpleMinHeap.add(i);
        }

        // Check if elements in 'arr' are in ascending order
        for (int i = 0; i < simpleMinHeap.arr.size() - 1; i++) {
            Assertions.assertTrue(simpleMinHeap.arr.get(i).compareTo(simpleMinHeap.arr.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testAddHundredElements() {
        SimpleMinHeap<Integer> simpleMinHeap = new SimpleMinHeap<>();
        for (int i = 100; i >= 1; i--) {
            simpleMinHeap.add(i);
        }

        // Check if elements in 'arr' are in ascending order
        for (int i = 0; i < simpleMinHeap.arr.size() - 1; i++) {
            Assertions.assertTrue(simpleMinHeap.arr.get(i).compareTo(simpleMinHeap.arr.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testAddRandomValues() {
        SimpleMinHeap<Integer> simpleMinHeap = new SimpleMinHeap<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randomValue = random.nextInt(1000);
            simpleMinHeap.add(randomValue);
        }

        // Check if elements in 'arr' are in ascending order
        for (int i = 0; i < simpleMinHeap.arr.size() - 1; i++) {
            Assertions.assertTrue(simpleMinHeap.arr.get(i).compareTo(simpleMinHeap.arr.get(i + 1)) <= 0);
        }
    }
}