import java.util.Stack;

class Solution {
    public static class State {
        public final int index;
        public final int acc;
        State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int count = 0;
        
        Stack<State> s = new Stack<>();
        s.push(new State(0, 0));
        
        while (!s.isEmpty()) {
            State state = s.pop();
            if (state.index == numbers.length) {
                if(state.acc == target) count++;
                continue;
            }
            
            s.push(new State(state.index+1, state.acc - numbers[state.index]));
            s.push(new State(state.index+1, state.acc + numbers[state.index]));
        }
        
        return count;
    }
}