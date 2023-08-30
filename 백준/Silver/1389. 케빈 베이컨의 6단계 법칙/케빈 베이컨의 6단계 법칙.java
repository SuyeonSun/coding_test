import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] list;
	private static boolean[] isVisited;
	private static int total;
	
	public static void bfs(int v) {
		Queue<int[]> queue = new LinkedList<>();
		
		isVisited[v] = true;
		queue.add(new int[] {v, 0});
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			total += poll[1];
			for (int i = 0; i < list[poll[0]].size(); i++) {
				if (!isVisited[list[poll[0]].get(i)]) {
					queue.add(new int[] {list[poll[0]].get(i), poll[1]+1});
					isVisited[list[poll[0]].get(i)] = true;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		
		for (int i = 1; i <= N; i++) {
			isVisited = new boolean[N+1];
			total = 0;
			bfs(i);
			if(total < min) {
				 min = total;
				 answer = i;
			}
		}
		System.out.println(answer);
	}
}