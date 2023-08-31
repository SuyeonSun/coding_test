import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static boolean[] isVisited;
	private static ArrayList<Integer>[] list;
	private static int friendCnt;
	
	public static void bfs(int v, int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		isVisited[v] = true;
		queue.add(new int[] {v, cnt});
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			if (poll[1] == 1 || poll[1] == 2) {
				friendCnt++;
			}
			
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
		int N = Integer.parseInt(in.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'Y') {
					list[i].add(j);
				}
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			friendCnt = 0;
			bfs(i, 0);	
			if (max < friendCnt) max = friendCnt;
		}
		
		System.out.println(max);
	}
}
