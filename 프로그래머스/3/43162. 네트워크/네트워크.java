import java.util.*;

class Solution {
    static boolean visit[];
    static Queue<Integer> queue = new LinkedList<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                bfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs(int i, int n, int[][] computers) {
        queue.add(i);
        visit[i] = true;
        
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int j = 0; j < n; j++) {
                if (visit[j] == false && computers[poll][j] == 1) {
                    visit[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}