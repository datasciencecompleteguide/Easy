package com.company;

import java.util.Stack;

public class InFixToPostFix {

    static int prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String InfixToPostfix(String string){
        String str = "";

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<string.length(); i++){
            char ch = string.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                str += Character.toString(ch);
            }
            else if (ch == '('){
                stack.push(ch);
            }
            else if (ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '(')
                    str += stack.pop();
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
                    str += stack.pop();
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            str += stack.pop();
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(InfixToPostfix(s));
    }
}