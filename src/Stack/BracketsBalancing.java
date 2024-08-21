package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BracketsBalancing
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);

            if(c=='{' || c=='[' || c=='(')
            {
                st.push(c);
            }
            else if(!st.empty() && (
                    (c=='}' && st.peek()=='{')||
                            (c==']' && st.peek()=='[')||
                            (c==')' && st.peek()=='(')
                    ))
            {
                st.pop();
            }
            else {
                st.push(c);
            }
        }

        if(!st.empty())
        {
            System.out.println("Brackets Unbalanced");
        }
        else
        {
            System.out.println("Brackets Balanced");
        }
    }
}
