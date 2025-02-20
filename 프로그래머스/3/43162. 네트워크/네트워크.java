import java.util.*;

class Solution {
    static boolean[] visit;
    static Queue<Integer> queue = new LinkedList<>();
    
    private static void bfs(int i, int[][] computers, int n) {
        queue.offer(i);
        visit[i] = true;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            for(int j=0; j<n; j++) {
                if(visit[j] == false && computers[value][j] == 1) {
                    visit[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(visit[i] == false) {
                bfs(i, computers, n);
                answer += 1;
            }
        }
        
        return answer;
    }
}