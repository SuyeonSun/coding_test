import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int c = poll[2];
            if (x == N - 1 && y == M - 1) {
                return c;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, c+1});
                }
            }
        }
        return -1;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }        

        int answer = bfs();
        System.out.println(answer);
	}
}