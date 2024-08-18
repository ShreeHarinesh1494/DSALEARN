package LinkedList;

import java.util.Scanner;

public class Main
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }

        LinkedList ls = new LinkedList(a[0]);

        for(int i=1;i<n;i++)
        {
            ls.append(a[i]);
        }

        ls.printList();
        ls.printHead();
        ls.printTail();
        ls.printLength();
        ls.append(6);
        ls.printList();
        ls.removeLast();
        ls.printList();
        ls.prepend(0);
        ls.printList();
        ls.removeFirst();
        ls.printList();
        System.out.println(ls.getValue(4).value);
        ls.setValue(0,0);
        ls.printList();
        ls.insertValue(1,5);
        ls.printList();
    }
}
