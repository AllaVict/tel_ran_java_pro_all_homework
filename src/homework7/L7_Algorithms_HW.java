package homework7;

import java.util.Stack;

public class L7_Algorithms_HW {
    /**Последовательность ([{}]) является правильной,
     * а последовательности ([)], {()] правильными не являются.
     * Докажите это используя стек! */

    public static void main(String[] args) {
        String inputString1 = "([{}])";
        String inputString2 = "([)]";
        String inputString3 = "{()]";
        System.out.println(isValidParentheses(inputString1));
        System.out.println(isValidParentheses(inputString2));
        System.out.println(isValidParentheses(inputString3));
    }


    public static boolean isValidParentheses(String s) {
        Stack<Character> charsStack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    charsStack.push(')');
                    break;
                case '{':
                    charsStack.push('}');
                    break;
                case '[':
                    charsStack.push(']');
                    break;

                case ')':
                case '}':
                case ']':
                    char topElement = charsStack.empty() ? '_' : charsStack.pop();
                    if (topElement != c)
                        return false;
                    break;
            }
        }

        return charsStack.isEmpty();
    }


}


