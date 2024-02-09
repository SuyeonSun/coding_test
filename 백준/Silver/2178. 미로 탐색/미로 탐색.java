import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[][] dist;
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};

	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		dist[i][j] = 0; // 첫 시작이기 때문에 거리는 0이다.

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				// 벽에 부딪히거나 범위를 넘어가는 경우
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				// 길이 아니거나 이미 방문을 한 경우
				if (arr[nx][ny] == 0 || dist[nx][ny] != -1) continue;

				queue.add(new int[]{nx, ny});
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
		System.out.println(dist[N-1][M-1] + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dist = new int[N][M];

		for (int n = 0; n < N; n++) {
			String str = in.readLine();
			for (int m = 0; m < M; m++) {
				arr[n][m] = str.charAt(m) - '0';
				dist[n][m] = -1;
			}
		}

		bfs(0, 0);
	}
}