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
	private static boolean[][] isVisited;
	private static final int[] dx = {-1, 1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};

	public static int bfs(int i, int j, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j, c});
		isVisited[i][j] = true;
		int cnt = 0;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			int z = poll[2];

			if (x == N - 1 && y == M - 1) return z;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (arr[nx][ny] == 1 && !isVisited[nx][ny]) {
					queue.add(new int[] {nx, ny, z + 1});
					isVisited[nx][ny] =  true;
				}
			}
		}

		return c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		isVisited = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			String str = in.readLine();
			for (int m = 0; m < M; m++) {
				arr[n][m] = str.charAt(m) - '0';
			}
		}

		int answer = bfs(0, 0, 1);
		System.out.println(answer);
	}
}