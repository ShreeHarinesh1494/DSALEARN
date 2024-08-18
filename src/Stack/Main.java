package Stack;

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

        Stack st  =new Stack(a[0]);
        for(int i=1;i<n;i++)
        {
            st.push(a[i]);
        }

        st.printStack();
        st.getTop();
        st.getHeight();
        System.out.println(st.pop());
    }
}
