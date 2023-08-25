import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] people;
	static int[][] vertexList;
	static int[] selection;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		people = new int[N];
		vertexList = new int[N][];
		selection = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			vertexList[i] = new int[s];
			for(int j = 0; j<s; j++) {
				vertexList[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		int c = 0;
		for(int i =0; i<N; i++) {
			if(selection[i] == 0) {
				selection[i] = ++c; 
				bfs(i);
			}
		}
		
		if(c >= 3) {
			System.out.println("-1");
			return;
		}
		else if(c == 2) {
			System.out.println(checkSum());
			return;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = N/2; i> 0; i--) {
			for(int j = 0; j<N; j++) {
				if(j<i) selection[j] = 0;
				else selection[j] = 1;
			}
xx:			do {
				boolean flag1 = false, flag2 = false;
				for(int j = 0; j<N; j++) {
					if(selection[j] == 0 && !flag1) {
						flag1 = bfs2(j);
						if(!flag1) continue xx;
					}
					else if(selection[j] == 1 ) {
						flag2= bfs2(j);
						if(!flag2) continue xx;
					}
				}
				
				int t = checkSum();
				min = min > t? t:min;
			}while(nextPermutation(selection));
		}
		System.out.println(min);
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int s = q.poll();
			for (int e : vertexList[s]) {
				if(selection[e] != 0) continue;
				selection[e] = selection[s];
				q.offer(e);
			}
		}
	}
	
	static boolean bfs2(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int s = q.poll();
			for(int e: vertexList[s]) {
				if(selection[e] != selection[s]) continue;
				if(visited[e]) continue;
				visited[e] = true;
				q.offer(e);
			}
		}
		
		for(int i = 0; i<N; i++) {
			if(selection[start] == selection[i]) {
				if(!visited[i]) return false;
			}
		}
		return true;
	}
	
	static int checkSum() {
		int s1 = 0, s2 = 0;
		for(int i = 0; i<N; i++) {
			if(selection[i] == 1) {
				s1 += people[i];
			}
			else s2 += people[i];
		}
		
		return Math.abs(s1-s2);
	}
	
	static void swap(int[] p, int i, int j) {
		int t = p[i];
		p[i] = p[j];
		p[j] = t;
	}
	
	static boolean nextPermutation(int[] p) {
		int n = p.length;
		int i = n-1;
		while(i> 0 && p[i-1] >= p[i]) i--;
		if(i == 0) return false;
		
		int j = n-1;
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k = n-1;
		while(i < k) {
			swap(p, i++, k--);
		}
		
		return true;
	}
	
}