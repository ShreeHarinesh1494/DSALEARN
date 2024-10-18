package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix
{
    public static int prec(Character c)
    {
        if(c=='^')
        {
            return 3;
        }
        else if(c=='/' || c=='*')
        {
            return 2;
        }
        else if(c=='+'|| c=='-')
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public static String Infixtoprefix(String str)
    {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=str.length()-1;i>=0;i--)
        {
            char c = str.charAt(i);

            if(Character.isLetterOrDigit(c))
            {
                result.append(c);
            }

            else if(c==')')
            {
                st.push(c);
            }

            else if(c=='(')
            {
                while(!st.empty() && st.peek()==')')
                {
                    result.append(st.pop());
                }
                st.pop();
            }
            else
            {
                while(!st.empty() && prec(c)<=prec(st.peek()))
                {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        while(!st.isEmpty())
        {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = Infixtoprefix(str);
        System.out.print(ans);
    }
}
