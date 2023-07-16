import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character str = s.charAt(i);
            if (str == '(') {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    return false; // 
                } else {
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) {
            answer = true;
        }
        
        return answer;
    }
}