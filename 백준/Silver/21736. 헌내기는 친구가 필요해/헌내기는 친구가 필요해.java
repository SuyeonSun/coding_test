import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int N;
	private static int M;
	private static Character[][] arr;
	private static boolean[][] visited;
	private static int cnt = 0;
	
	public static void search(int x, int y) {
		visited[x][y] = true;
		
		if (arr[x][y] == 'P') {
			cnt++;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= N || nx < 0 || ny >= M || ny < 0 || arr[nx][ny] == 'X') continue;
			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				search(x + dx[i], y + dy[i]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Character[N][M];
		visited = new boolean[N][M];
		
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		
		search(x, y);
		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}
}