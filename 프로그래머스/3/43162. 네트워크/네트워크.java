import java.util.*;

class Solution {
    private static boolean[] isVisited;
    
    private static void bfs(int idx, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[poll][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i] && computers[i][j] == 1) {
                    bfs(i, computers);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}