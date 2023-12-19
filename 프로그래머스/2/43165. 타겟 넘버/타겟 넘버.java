import java.util.*;

class Solution {
    public static class State {
        public final int idx;
        public final int acc;
        
        State(int idx, int acc) {
            this.idx = idx;
            this.acc = acc;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Stack<State> stack = new Stack<>();
        stack.push(new State(0, 0));
        
        while(!stack.isEmpty()) {
            State pop = stack.pop();
            if (pop.idx == numbers.length) {
                if (target == pop.acc) {
                    answer++;
                }
                continue;
            }
            
            stack.push(new State(pop.idx+1, pop.acc + numbers[pop.idx]));
            stack.push(new State(pop.idx+1, pop.acc - numbers[pop.idx]));
        }
        
        
        return answer;
    }
}