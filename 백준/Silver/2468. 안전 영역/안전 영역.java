import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int min;
	static int max;
	
	public static void dfs(int x, int y, int k) {
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;
			if (arr[nx][ny] >= k && !visited[nx][ny]) {
				dfs(nx, ny, k);
			}
		}		
	}
	
	public static void main(String[] args) throws IOException {
		// 1. 배열 입력 && max 값 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int answer = Integer.MIN_VALUE;
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = in.readLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if (min > arr[i][j]) min = arr[i][j];
				if (max < arr[i][j]) max = arr[i][j];
			}
		}
		
		// 2. visited 배열 선언
		visited = new boolean[N][N];
		
		// 3. max 값으로 dfs 돌리기
		for (int k = max; k >= min; k--) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] >= k && !visited[i][j]) {
						cnt++;
						dfs(i, j, k);
					}
				}
			}
			
			if (answer < cnt) {
				answer = cnt;
			}
		}
		System.out.println(answer);
	}
}