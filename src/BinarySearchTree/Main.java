package BinarySearchTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }

        BinarySearchTree bs = new BinarySearchTree();
        for(int i=0;i<n;i++)
        {
            bs.insert(a[i]);
        }

        ArrayList<Integer> INO = bs.DFSInOrder();
        bs.printList(INO);
        System.out.println();
        ArrayList<Integer> PRE = bs.DFSPreOrder();
        bs.printList(PRE);
        System.out.println();
        ArrayList<Integer> POST = bs.DFSPostOrder();
        bs.printList(POST);
        System.out.println();
        System.out.println("Height of the Tree : "+bs.calculateheight());
        System.out.println("Sum of the Tree Leaves : "+bs.sumofleaf());
    }
}
