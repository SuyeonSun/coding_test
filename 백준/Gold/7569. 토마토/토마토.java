import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>(); 

    private static void bfs() {
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int z = poll[0];
            int y = poll[1];
            int x = poll[2];
            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) {
                    continue;
                }
                if (box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = box[z][y][x] + 1;
                    queue.add(new int[] {nz, ny, nx});
                }
            }
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M]; // 초기화 추가!
        
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(in.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) { // 익은 토마토만 큐에 넣기
                        queue.add(new int[] {h, n, m});
                    }
                }
            }   
        }

        bfs();

        int days = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) { // 안 익은 토마토 있으면
                        System.out.println(-1);
                        return;
                    }
                    days = Math.max(days, box[h][n][m]);
                }
            }
        }
        System.out.println(days - 1); // 첫 날 1부터 시작했으니 -1
	}
}
