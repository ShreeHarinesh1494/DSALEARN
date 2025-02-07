package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InflixOperation
{
     static public int inflix(String str) {
         Stack<Integer> no = new Stack<>();
         Stack<Character> st = new Stack<>();

         for (int i = 0; i < str.length(); i++)
         {
             char ch = str.charAt(i);
             if (Character.isDigit(ch)) {
                 int num = 0;
                 while (i < str.length() && Character.isDigit(str.charAt(i))) {
                     num = num * 10 + (str.charAt(i) - '0');
                     i++;
                 }
                 i--;
                 no.push(num);
             }
             else if (ch == '(')
             {
                 st.push(ch);
             }
             else if (ch == ')')
             {
                 while (!st.isEmpty() && st.peek() != '(')
                 {
                     if(no.size()<2) return Integer.MIN_VALUE;
                     no.push(operations(no.pop(), no.pop(), st.pop()));
                 }
                 st.pop();
             }
             else
             {
                 while (!st.isEmpty() && prec(st.peek()) >= prec(ch))
                 {
                     if(no.size()<2) return Integer.MIN_VALUE;
                     no.push(operations(no.pop(), no.pop(), st.pop()));
                 }
                 st.push(ch);
             }
         }

         while (!st.isEmpty())
         {
             if(no.size()<2) return Integer.MIN_VALUE;
             no.push(operations(no.pop(), no.pop(), st.pop()));
         }
         return no.pop();
     }

        static int prec(char ch)
        {
            switch (ch)
            {
                case '+': case '-' : return 1;
                case '*' : case '/' : return 2;
                default:return 0;
            }
        }

        static int operations(int b,int a,char ch)
        {
            switch (ch)
            {
                case '+':return a+b;
                case '-':return a-b;
                case '*':return a*b;
                case '/':return a/b;
            }
            return 0;
        }





    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = inflix(str);
        System.out.println(ans);
    }
}
