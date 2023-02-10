package leetcode;

/* https://leetcode.com/problems/valid-parentheses/ */

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([}}])";
        System.out.println(s.toCharArray());

        System.out.println("Result: "+ checkParentheses(s));


    }

    private static boolean checkParentheses (String s) {
        if (s.length() % 2 != 0) return false;
        int i = 0;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' : st.push(c); i++; break;
                case '{' : st.push(c); i++; break;
                case '[' : st.push(c); i++; break;
                case ')' : if (!st.isEmpty() && st.peek() == '(') st.pop(); i--; break;
                case '}' : if (!st.isEmpty() && st.peek() == '{') st.pop(); i--; break;
                case ']' : if (!st.isEmpty() && st.peek() == '[') st.pop(); i--; break;
                default:
                    System.out.println("You all doing wrong....!!!");
            }
        }

        if (i==0 && st.empty())
            return true;
        return false;
    }
}
