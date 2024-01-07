import java.util.*;

class Solution {
    private static boolean[] visit;
    private static int answer = 0;
    
    private void bfs(int idx, int n, int[][] computers) {
        visit[idx] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < n; i++) {
                if (computers[poll][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
                
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visit[i]) {
                    bfs(i, n, computers);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}