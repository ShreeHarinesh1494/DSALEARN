package Stack;

import java.util.Stack;

public class InStack {
    private Node top;
    private int height;

    class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
        }
    }

    InStack(int value)
    {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack()
    {
        Node temp = top;
        while(temp!=null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop()
    {
        System.out.println("Top : "+top.value);
    }

    public void getHeight()
    {
        System.out.println("Height : "+height);
    }

    public void push(int value)
    {
        Node newNode = new Node(value);
        if(height==0)
        {
            top = newNode;
        }
        else
        {
            newNode.next=top;
            top = newNode;
        }
        height++;
    }

    public int pop()
    {
        if(height==0)
        {
            return -1;
        }
        else
        {
            Node temp = top;
            top = temp.next;
            temp.next=null;
            height--;
            return temp.value;
        }
    }


    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public String infixToPrefix(String expression) {
        // Reverse the infix expression
        StringBuilder exp = new StringBuilder(expression).reverse();

        // Replace '(' with ')' and vice versa
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(') {
                exp.setCharAt(i, ')');
            } else if (c == ')') {
                exp.setCharAt(i, '(');
            }
        }

        // Get postfix expression of the modified expression
        String postfix = infixToPostfix(exp.toString());

        // Reverse the postfix expression to get prefix expression
        return new StringBuilder(postfix).reverse().toString();
    }

    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public int evaluateInfix(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                values.push(c - '0');
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOperation(values.pop(), values.pop(), ops.pop()));
                }
                ops.pop(); // Remove '('
            } else if (precedence(c) > 0) {
                while (!ops.isEmpty() && precedence(c) <= precedence(ops.peek())) {
                    values.push(applyOperation(values.pop(), values.pop(), ops.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOperation(values.pop(), values.pop(), ops.pop()));
        }

        return values.pop();
    }

    private int applyOperation(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
    

}
