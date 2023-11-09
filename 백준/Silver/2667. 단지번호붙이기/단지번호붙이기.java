import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] arr;
    static boolean[][] isVisited;
    static int answer = 0;
    static int cnt = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        isVisited[i][j] = true;
        cnt++;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= N || ny >= N || nx < 0 || ny < 0 || isVisited[nx][ny]) continue;
                if (arr[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny});
                    isVisited[nx][ny] = true;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !isVisited[i][j]) {
                    answer++;
                    cnt = 0;
                    bfs(i, j);
                    pq.add(cnt);
                }
            }
        }

        System.out.println(answer);
        for (int i = 0; i < answer; i++) {
            System.out.println(pq.poll());
        }
    }
}