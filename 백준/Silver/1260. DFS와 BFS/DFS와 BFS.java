import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int N;
	static int M;
	static int V;
	static int[][] arr;
	static boolean[] visited;	
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		for (int i = 1; i < arr.length; i++) {
			if (!visited[i] && arr[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[v] = true;
		queue.add(v);
		sb.append(v + " ");
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			for (int i = 1; i < arr.length; i++) {
				if (!visited[i] && arr[poll][i] == 1) {
					queue.add(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		arr = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			String[] input2 = in.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		visited = new boolean[N+1];	
		dfs(V);
		sb.append("\n");

		visited = new boolean[N+1];	
		bfs(V);
		System.out.println(sb);
	}
}