import java.util.*;

class Solution {
    Queue<int[]> q = new LinkedList<>();
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        q.offer(new int[] {numbers[0], 0});
        q.offer(new int[] {numbers[0] * (-1), 0});
        
        while (!q.isEmpty()) {
            int num = q.peek()[0];
            int idx = q.peek()[1];
            q.poll();
            idx++;
            
            if (idx < numbers.length) {
                q.offer(new int[] {num + numbers[idx], idx});
                q.offer(new int[] {num + (-1) * numbers[idx], idx});
            }
            
            if (idx == numbers.length) {
                if (num == target) answer++;
            }
        }
        
        return answer;
    }
}