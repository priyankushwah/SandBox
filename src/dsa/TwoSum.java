package dsa;

import java.util.Stack;

public class TwoSum {
    public static void main(String[] args){
        String s = "(])";
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if(stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')){
                System.out.println(false);
                return;
            }
            else if(!stack.isEmpty() && (stack.peek() == '(' && s.charAt(i) != ')'
                        || stack.peek() == '[' && s.charAt(i) != ']'
                        || stack.peek() == '{' && s.charAt(i) != '}') ) {
                System.out.println(false);
                return;
            }else
                stack.pop();
        }

        System.out.println(stack.isEmpty());
    }
}
