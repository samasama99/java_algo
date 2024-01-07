// * javascript code *
//  var heap = new MinHeap();
//  heap.push(4);
//  heap.push(1);
//  heap.push(7);
//  heap.push(9);
//  heap.push(2);
//  console.log( heap.pop()); // 1
//          console.log( heap.pop()); // 2
//          console.log( heap.pop()); // 4
//          console.log( heap.pop()); // 7
//          console.log( heap.pop()); // 9

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleMinHeap<T extends Comparable<T>> {

    List<T> arr = new ArrayList<>();

    void add(T newElement) {
        if (arr.isEmpty()) {
            arr.add(newElement);
            return;
        }
        int index = arr.size();
        arr.add(newElement);
        int parentIndex = (index - 2) / 2;
        T parent = arr.get(parentIndex);
        while (newElement.compareTo(parent) < 0) {
            Collections.swap(arr, index, parentIndex);
            index = parentIndex;
            if (parentIndex == 0) return;
            parentIndex = (index - 2) / 2;
            parent = arr.get(parentIndex);
        }
    }

    T pop() {
        if (arr.isEmpty()) {
            throw new EmptyStackException();
        }
        if (arr.size() == 1) {
            return arr.remove(0);
        }
        if (arr.size() == 2) {
            return arr.remove(0);
        }
        if (arr.size() == 3) {
            if (arr.get(1).compareTo(arr.get(2)) < 0) {
                return arr.remove(0);
            }
            Collections.swap(arr, 1, 2);
            return arr.remove(0);
        }

        final T lastElement = arr.remove(arr.size() - 1);
        final T firstElement = arr.get(0);

        arr.set(0, lastElement);
        T leftChild = arr.get(1);
        T rightChild = arr.get(2);
        T currentElemet = arr.get(0);
        int index = 0;
        while (true) {
            if ((leftChild != null && currentElemet.compareTo(leftChild) > 0)) {
                Collections.swap(arr, index, (index * 2) + 1);
                index = (index * 2) + 1;
            } else if ((rightChild != null && currentElemet.compareTo(rightChild) > 0)) {
                Collections.swap(arr, index, (index * 2) + 2);
                index = (index * 2) + 2;
            } else {
                break;
            }
            try {
                leftChild = arr.get((index * 2) + 1);
            } catch (Exception e) {
                leftChild = null;
            }
            try {
                rightChild = arr.get((index * 2) + 2);
            } catch (Exception e) {
                rightChild = null;
            }
            currentElemet = arr.get(index);
        }
        return firstElement;
    }

    void addAll(List<T> newElements) {
        newElements.forEach(this::add);
    }

    @Override
    public String toString() {
        return arr
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public static void main(String[] args) {
        SimpleMinHeap<Integer> simpleMinHeap = new SimpleMinHeap<>();

        simpleMinHeap.add(4);
        simpleMinHeap.add(1);
        simpleMinHeap.add(7);
        simpleMinHeap.add(9);
        simpleMinHeap.add(2);
        while (true) {
            try {
                System.out.println(simpleMinHeap.pop());
            } catch (Exception e) {
                break;
            }
        }
    }
}
