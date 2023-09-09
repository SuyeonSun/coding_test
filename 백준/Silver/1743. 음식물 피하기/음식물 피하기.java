import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int cnt = 0;
    static int max= Integer.MIN_VALUE;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    cnt = 1;
                    dfs(i, j);
                    if (cnt > max) max = cnt;
                }
            }
        }
        System.out.println(max);
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx < 0 || ny < 0 || nx > N || ny > M) continue;
            if (!visited[nx][ny] && arr[nx][ny] == 1) {
                dfs(nx, ny);
                cnt++;
            }
        }
    }
}