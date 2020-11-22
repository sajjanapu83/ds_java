package com.codewithmosh;

import java.util.Stack;

public class StringFuncForStacks {

    public static void main(String[] args) {
        // stringReverse();
        ValidateParanthesis validate = new ValidateParanthesis();
        boolean value = validate.validate("({{1+2)}>");
        System.out.println(value);

    }



    public void stringReverse() {
        String str = "abcde";
        Stack<Character> stack = new Stack<>();

        for (Character ch : str.toCharArray())
            stack.push(ch);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
