import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int toRemove = k;
        
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < digit) {
                if (toRemove == 0) break;
                stack.pop();
                toRemove--;
            }
            stack.push(digit);
        }
        
        for (int i = 0; i < number.length() - k; i++) {
            answer += stack.get(i);
        }
        
        return answer;
    }
}