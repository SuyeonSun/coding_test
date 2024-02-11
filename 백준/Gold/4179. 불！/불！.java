import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R; // TODO: private 붙으면 안되는 이유
	static int C;
	static String[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> jh = new LinkedList<>(); // TODO: 큐를 두개 선언
	static Queue<int[]> fire = new LinkedList<>();
	static int answer;

	public static boolean bfs() {
		while (!jh.isEmpty()) {
			// 불이 먼저 퍼진다.
			int fireSize = fire.size();
			for (int i = 0; i < fireSize; i++) {
				int[] poll = fire.poll();
				for (int d = 0; d < 4; d++) {
					int xx = poll[0] + dx[d];
					int yy = poll[1] + dy[d];
					int t = poll[2];

					// 범위를 벗어나면 pass
					if (xx < 0 || yy < 0 || xx >= R || yy >= C) continue;
					// 벽이거나 불이면 pass
					if (arr[xx][yy].equals("#") || arr[xx][yy].equals("F")) continue;
					arr[xx][yy] = "F";
					fire.add(new int[] {xx, yy, t+1});
				}
			}

			// 지훈이가 불을 피해 이동한다.
			int jhSize = jh.size();
			for (int i = 0; i < jhSize; i++) {
				int[] poll = jh.poll();
				for (int d = 0; d < 4; d++) {
					int xx = poll[0] + dx[d];
					int yy = poll[1] + dy[d];
					int t = poll[2];

					// 지훈이는 범위를 벗어나면 탈출 // TODO
					if (xx < 0 || yy < 0 || xx >= R || yy >= C) {
						answer = t + 1;
						return true;
					}

					// 벽이거나 불이면 pass // 이미 방문한 곳이면 pass
					if (arr[xx][yy].equals("#") || arr[xx][yy].equals("F") || arr[xx][yy].equals("J")) continue;
					arr[xx][yy] = "J";
					jh.add(new int[] {xx, yy, t+1});
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		// #: 벽
		// .: 지나갈 수 있는 공간
		// J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
		// F: 불이 난 공간

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[R][C];

		for(int i = 0; i < R; i++) {
			String[] str = in.readLine().split("");
			for(int j = 0; j < C; j++) {
				arr[i][j] = str[j];
				if (arr[i][j].equals("J")) {
					jh.add(new int[]{i, j, 0});
				}
				if (arr[i][j].equals("F")) {
					fire.add(new int[]{i, j, 0});
				}
			}
		}

		if (bfs()) {
			System.out.println(answer);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}
}