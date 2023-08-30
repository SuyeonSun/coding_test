import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, ans = Integer.MAX_VALUE;
	static int cost[][];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		visited = new boolean[N];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				if(cost[i][j] == 0) cost[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i<N; i++) {
			visited[i] = true;
			dfs(i, 0, 1, i);
			visited[i] = false;
		}
		System.out.println(ans);
	}

	static void dfs(int from, int c, int depth, int start) {
		if(depth == N && from != N-1) return;
		if(from == N-1) {
			if(depth == N) {
				if(cost[from][start] != Integer.MAX_VALUE) {
					ans = Math.min(ans, c+cost[from][start]);
				}
				return;
			}
		}
		
		for(int i =0; i<N; i++) {
			if(visited[i]) continue;
			if(cost[from][i] != Integer.MAX_VALUE) {
				visited[i] = true;
				dfs(i, c+cost[from][i], depth+1, start);
				visited[i] = false;
			}
		}
	}
}