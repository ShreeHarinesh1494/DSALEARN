package Queue;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Queue que = new Queue(5);
        que.Enqueue(6);

        que.printQueue();
        que.getFirst();
        que.getLast();
        que.getLength();
        que.Dequeue();
        que.printQueue();
    }
}
