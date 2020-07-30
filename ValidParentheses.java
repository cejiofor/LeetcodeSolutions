package com.leetcode;

import java.util.Stack;

public class ValidParentheses {
    /* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
            An input string is valid if:
                Open brackets must be closed by the same type of brackets.
                Open brackets must be closed in the correct order.
                Note that an empty string is also considered valid.
     */
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid(""));
        System.out.println(new ValidParentheses().isValid("()"));
        System.out.println(new ValidParentheses().isValid("([)]"));
        System.out.println(new ValidParentheses().isValid("{[()]}"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (!stack.isEmpty() && stack.peek().equals(c)) {
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
    public boolean isValidComplex(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': case '{': case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek().equals('(')) {
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek().equals('[')) {
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek().equals('{')) {
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
