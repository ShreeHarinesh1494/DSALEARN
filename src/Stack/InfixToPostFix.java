package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {

    // Method to check precedence of operators
    public static int prec(Character c) {
        if (c == '^') {
            return 3;
        } else if (c == '/' || c == '*') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    // Method to convert infix to postfix
    public static String Infixtopostfix(String str) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Traverse the infix expression from left to right
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // If the character is an operand (a-z, A-Z, 0-9), add it to result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the character is '(', push it to the stack
            else if (c == '(') {
                st.push(c);
            }
            // If the character is ')', pop from stack until '(' is found
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop(); // Remove '(' from stack
            }
            // If the character is an operator
            else {
                while (!st.isEmpty() && prec(c) <= prec(st.peek())) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        // Pop all remaining operators from the stack
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();  // No need to reverse for postfix
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression:");
        String str = sc.nextLine();
        String ans = Infixtopostfix(str);  // Call the correct method
        System.out.print("Postfix Expression: " + ans);
        sc.close();
    }
}

