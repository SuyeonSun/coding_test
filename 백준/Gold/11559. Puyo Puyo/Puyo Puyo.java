import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Character[][] arr;
    public static boolean[][] isVisited;
    public static int cnt = 0;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int colors = 0;

    // TODO
    public static void move(int idx) {
        if (idx >= 6) return;
        for (int j = 1; j < 12; j++) {
            if (arr[j][idx] == '.' && arr[j-1][idx] != '.') {
                arr[j][idx] = arr[j-1][idx];
                arr[j-1][idx] = '.';
                move(idx);
            } else {
                move(idx+1);
            }

        }
    }
    
    public static void bfs(int i, int j, Character str) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int d= 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= 12 || ny < 0 || ny>= 6) continue;
                if (arr[nx][ny] == str) {
                    arr[nx][ny] = '.';
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    public static void find(int i, int j, Character str) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        isVisited[i][j] = true;
        colors++;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int d= 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= 12 || ny < 0 || ny>= 6 || arr[nx][ny] != str) continue;
                if (!isVisited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    isVisited[nx][ny] = true;
                    colors++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        arr = new Character[12][6];
        for (int i = 0; i < 12; i++) {
            String str = in.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 한번 시작
        while(true) {
            Boolean isRotate = false;
            isVisited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.' && !isVisited[i][j]) {
                        find(i, j, arr[i][j]);
                        if (colors >= 4) {
                            bfs(i, j, arr[i][j]);
                            isRotate = true;
                        }
                        colors = 0;
                    }
                }
            }
            if (isRotate) {
                move(0);
                cnt++;
            } else break;
        }
        // 한번 끝
        
        System.out.println(cnt);
    }
}