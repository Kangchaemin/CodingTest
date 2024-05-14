import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        for(int offset = 0; offset < s.length(); offset++){
            if(check(s, offset))
                count++;
        }
        return count;
    }
    
    public boolean check(String s, int offset){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt((i+offset) % s.length());
            switch(c){
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != c) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
