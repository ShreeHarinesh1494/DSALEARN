package DoubleLinkedList;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }

        DoubleLinkedList ds = new DoubleLinkedList(a[0]);
        ds.printList();
        ds.printHead();
        ds.printTail();
        for(int i=1;i<n;i++)
        {
            ds.append(a[i]);
        }

        ds.printList();
        ds.printLength();
        ds.prepend(45);
        ds.printList();
        ds.printLength();
        ds.removeFirst();
        ds.printList();
        ds.removeLast();
        ds.printList();
        ds.setValue(1,10);
        ds.printList();
        ds.insert(1,15);
        ds.printList();
    }
}
