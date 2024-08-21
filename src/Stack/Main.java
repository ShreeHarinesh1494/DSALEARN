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

        InStack st  =new InStack(a[0]);
        for(int i=1;i<n;i++)
        {
            st.push(a[i]);
        }

        st.printStack();
        st.getTop();
        st.getHeight();
        System.out.println(st.pop());

        String infixExpression = "3+(2*2)-4";
        System.out.println("Infix to Postfix: " + st.infixToPostfix(infixExpression));
        System.out.println("Infix to Prefix: " + st.infixToPrefix(infixExpression));

        String postfixExpression = "45+";
        System.out.println("Postfix Evaluation: " + st.evaluatePostfix(postfixExpression));

        String prefixExpression = "+45";
        System.out.println("Prefix Evaluation: " + st.evaluatePrefix(prefixExpression));

        System.out.println("Infix Evaluation: " + st.evaluateInfix(infixExpression));
    }
}
