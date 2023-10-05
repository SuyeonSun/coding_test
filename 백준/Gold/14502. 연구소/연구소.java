import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
// 1. dfs로 벽 세우기 (depth 활용)
// 2. dfs의 depth가 3이면, 즉 벽을 3개 세웠다면 queue에 add 
// 3. 2이면 queue에 더하기
// 4. while queue가 빌때까지 사방 탐색 큐에서 뺀 값의 사방이 0이면 2로 바꾸고 다시 queue에 add
// 5. 2인 개수 더하기

public class Main {
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[] dx = {0, -1, 1, 0};
	private static int[] dy = {1, 0, 0, -1};
	private static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(answer);
	}
	
	// dfs()
	public static void dfs(int depth) {
		if (depth == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(depth + 1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	// bfs()
	public static void bfs() {
		int[][] wallArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				wallArr[i][j] = arr[i][j];
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wallArr[i][j] == 2) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;
				if (wallArr[nx][ny] == 0) {
					wallArr[nx][ny] = 2;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		
		count(wallArr);
	}
	
	// count
	public static void count(int[][] wallArr) {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wallArr[i][j] == 0) {
					temp += 1;
				}
			}
		}
		if (temp > answer) answer = temp;
	}
}