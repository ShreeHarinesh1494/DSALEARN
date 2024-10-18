package Heaps;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap
{
    private List<Integer> heap;

    MaxHeap()
    {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap()
    {
        return new ArrayList<>(heap);
    }

    public int leftChild(int index)
    {
        return index*2+1;
    }

    public int rightChild(int index)
    {
        return index*2+2;
    }

    public int parent(int index)
    {
        return (index-1)/2;
    }

    public void swap(int index1,int index2)
    {
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }

    public void insert(int value)
    {
        heap.add(value);
        int curr = heap.size()-1;

        while(curr>0 && heap.get(curr)>heap.get(parent(curr)))
        {
            swap(curr,parent(curr));
            curr = parent(curr);
        }
    }

    public Integer remove()
    {
        if(heap.size()==0)
        {
            return null;
        }

        if(heap.size()==1)
        {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        sinkDown(0);
        return maxValue;
    }

    public void sinkDown(int index)
    {
        int maxIndex = index;

        while(true)
        {
            int leftchild1 = leftChild(index);
            int rightchild1 = rightChild(index);

            if(leftchild1<heap.size() && heap.get(leftchild1) > heap.get(maxIndex))
            {
                maxIndex = leftchild1;
            }

            if(rightchild1<heap.size() && heap.get(rightchild1) > heap.get(maxIndex))
            {
                maxIndex = rightchild1;
            }

            if(maxIndex!=index)
            {
                swap(index,maxIndex);
                index = maxIndex;
            }
            else
            {
                return;
            }
        }
    }
}

