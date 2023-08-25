import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] student;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		student = new int[N+1];
		
		for(int i = 0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(v).add(w);
			student[w]++;
		}
		
		bfs();
		
		System.out.println(sb);
		
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			if(student[i] == 0) {
				queue.offer(i);
				sb.append(i).append(' ');
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i : graph.get(cur)) {
				student[i]--;
				if(student[i] == 0) {
					queue.offer(i);
					sb.append(i).append(' ');
				}
			}
		}
	}
}