import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] visited;
	public static int[][] arr;
	public static Queue<int[]> queue = new LinkedList<>();
	public static int cnt = 1;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	public static int N;
	public static int M;

	public static int bfs(int i, int j, int c) {	
		queue.add(new int[] {i, j, c});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			int cnt = poll[2];
			if (x == N-1 && y == M-1) {
				return cnt;
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
				if (!visited[nx][ny] && arr[nx][ny] == 1) {
					queue.add(new int[] {nx, ny, cnt+1});
					visited[nx][ny] = true;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] input = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		System.out.println(bfs(0, 0, 1));
	}
}