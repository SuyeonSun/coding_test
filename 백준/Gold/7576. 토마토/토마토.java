import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<int[]> queue = new LinkedList<>(); // TODO: queue 글로벌 선언

	private static void bfs() {
		int day = 0;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			int z = poll[2];
			day = z;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if (arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					queue.add(new int[]{nx, ny, day+1});
				}
			}
		}

		// 하루가 지나고, 토마토가 모두 익었는지 확인
		checkTomato();
		if (checkTomato()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean checkTomato() {
		for (int p = 0; p < M; p++) {
			for (int q = 0; q < N; q++) {
				if (arr[p][q] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) { // TODO: 처음 상태가 1인 요소를 모두 queue에 add
					queue.add(new int[] {i, j, 0});
				}
			}
		}

		bfs();
	}
}