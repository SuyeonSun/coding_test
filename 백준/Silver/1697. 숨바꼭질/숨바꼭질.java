import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) System.out.println(0);
		else bfs();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		check[N] = 1;

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = temp + 1;
				} else if (i == 1) {
					next = temp - 1;
				} else {
					next = temp * 2;
				}

				if (next == K) {
					System.out.println(check[temp]);
					return;
				}

				if (next >= 0 && next < check.length && check[next] == 0) {
					queue.add(next);
					check[next] = check[temp] + 1;
				}
			}
		}
	}
}