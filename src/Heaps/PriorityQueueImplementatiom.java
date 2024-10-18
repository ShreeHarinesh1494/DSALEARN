package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueImplementatiom
{
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(99);
        maxHeap.add(75);
        maxHeap.add(65);
        maxHeap.add(58);
        maxHeap.add(100);

        // Max-Heap: Elements are retrieved in decreasing order
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());  // Output: 20, 10, 5, 1
        }
    }
}
