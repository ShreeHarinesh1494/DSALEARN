package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinHeap
{
    private List<Integer> heap;

    MinHeap()
    {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap()
    {
        return new ArrayList<>(heap);
    }

    public int leftChild(int index)
    {
        return index * 2 + 1;
    }

    public int rightChild(int index)
    {
        return index * 2 + 2;
    }

    public int parent(int index)
    {
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2)
    {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value)
    {
        heap.add(value);
        int curr = heap.size() - 1;

        // Min-heap comparison: if the current node is smaller than its parent
        while (curr > 0 && heap.get(curr) < heap.get(parent(curr)))
        {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public Integer remove()
    {
        if (heap.size() == 0)
        {
            return null;
        }

        if (heap.size() == 1)
        {
            return heap.remove(0);
        }

        int minValue = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        sinkDown(0);
        return minValue;
    }

    public void sinkDown(int index) {
        int minIndex = index;

        while (true) {
            int leftchild1 = leftChild(index);
            int rightchild1 = rightChild(index);

            // Min-heap comparison: if the left child is smaller than the current min
            if (leftchild1 < heap.size() && heap.get(leftchild1) < heap.get(minIndex)) {
                minIndex = leftchild1;
            }

            // Min-heap comparison: if the right child is smaller than the current min
            if (rightchild1 < heap.size() && heap.get(rightchild1) < heap.get(minIndex)) {
                minIndex = rightchild1;
            }

            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                return;
            }
        }
    }
}
class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MinHeap hp = new MinHeap();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int a = sc.nextInt();
            hp.insert(a);
        }

        System.out.println("Initial heap:");
        for (int element : hp.getHeap())
        {
            System.out.print(element + " ");
        }
        System.out.println();
        hp.insert(100);
        System.out.println("Modified heap:");
        for (int element : hp.getHeap())
        {
            System.out.print(element + " ");
        }

        hp.remove();
        System.out.println("Modified heap 2:");
        for (int element : hp.getHeap())
        {
            System.out.print(element + " ");
        }
    }
}
