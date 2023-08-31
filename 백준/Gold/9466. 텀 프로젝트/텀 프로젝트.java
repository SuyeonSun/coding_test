import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, cnt;
	static int[] student;
	static int[] visited;
	static boolean[] cycle;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			student = new int[N+1];
			visited = new int[N+1];
			cycle = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=N; i++) {
				student[i] = Integer.parseInt(st.nextToken());

				if(student[i] == i) {
					visited[i] = Integer.MAX_VALUE;
					cycle[i] = true;
				}
			}
//			System.out.println(Arrays.toString(student));
			for(int i = 1; i<=N; i++) {
				if(visited[i] != 0 || cycle[i]) continue;
				visited[i] = i;
				dfs(i, i);
			}
			
			for(int i = 1; i<=N; i++) {
				cnt += cycle[i]? 0:1;
			}
			System.out.println(cnt);
		}
	}
	
	static int dfs(int start, int seq) {
		int next = student[start];
		
		if(visited[next] == seq) return next;
		
		if(cycle[next]) return 0;
		if(visited[next]>0) return 0;
		
		visited[next] = seq;
		int flag = dfs(next, seq);
		if(flag == 0) return 0;
		else {
			cycle[next] = true;
			if(flag != start) return flag;
			else {
				cycle[flag] = true;
				return 0;
			}
		}
	} 
	
}