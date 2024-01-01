//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//        Evaluate the expression. Return an integer that represents the value of the expression.
//
//        Note that:
//
//        The valid operators are '+', '-', '*', and '/'.
//        Each operand may be an integer or another expression.
//        The division between two integers always truncates toward zero.
//        There will not be any division by zero.
//        The input represents a valid arithmetic expression in a reverse polish notation.
//        The answer and all the intermediate calculations can be represented in a 32-bit integer.
//

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> S.add(S.pop() + S.pop());
                case "/" -> {
                    b = S.pop();
                    a = S.pop();
                    S.add(a / b);
                }
                case "*" -> S.add(S.pop() * S.pop());
                case "-" -> {
                    b = S.pop();
                    a = S.pop();
                    S.add(a - b);
                }
                default -> S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }
}

class GFG {

    public static void main(String[] args)
    {
        // String Input
        String[] s
                = { "10", "6", "9",  "3", "+", "-11", "*",
                "/",  "*", "17", "+", "5", "+" };

        ReversePolishNotation str = new ReversePolishNotation();
        int result = str.evalRPN(s);
        System.out.println(result);
    }
}

