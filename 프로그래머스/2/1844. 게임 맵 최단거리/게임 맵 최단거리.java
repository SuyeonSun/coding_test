import java.util.*;

class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static Queue<int[]> queue = new LinkedList<>();
    
    private static int bfs(int[][] maps) {
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];
            
            if(x == maps.length-1 && y == maps[0].length-1) {
                return z;
            }
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                if (visited[nx][ny]) continue;
                
                if(maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, z+1});
                }
            }
            
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        answer = bfs(maps);
        
        return answer;
    }
}