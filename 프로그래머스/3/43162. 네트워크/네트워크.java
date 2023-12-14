import java.util.*;

class Solution {
    private void visitAll(int computer, int[][] computers, boolean[] isVisited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(computer);
        
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            
            // if (isVisited[pop]) continue;
            isVisited[pop] = true;
            
            for (int i = 0; i < computers[pop].length; i++) {
                if (computers[pop][i] == 0) continue;
                if (isVisited[i]) continue;
                stack.push(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] isVisited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) continue;
            visitAll(i, computers, isVisited);
            answer++;
        }
        
        
        return answer;
    }
}