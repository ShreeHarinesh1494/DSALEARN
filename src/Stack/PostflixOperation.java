package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PostflixOperation
{

    public static int getAnd(String str)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            Character c  = str.charAt(i);

            if(Character.isDigit(c))
            {
                st.push(c-'0');
            }

            else
            {
                int a = st.pop();
                int b = st.pop();

                switch (c) {
                    case '+':
                        st.push(a + b);
                        break;

                    case '-':
                        st.push(a - b);
                        break;
                    case '/':
                        st.push(a / b);
                        break;
                    case '%':
                        st.push(a % b);
                        break;

                }
            }
        }
        return st.pop();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int ans = getAnd(str);
        System.out.println(ans);
    }
}
