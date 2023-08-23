import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static List<Edge> edgeList = new ArrayList<>();
	static int[] parents;
	static int islandCnt;
	static int N, M;
	static int[][] field;
	
	static int[][] dir = {
		{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};
	
	public static void main(String[] args) throws IOException {
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				field[i][j] = -1*Integer.parseInt(st.nextToken());
			}
		}
		
		//bfs로 섬찾기 -> islandCount 업데이트
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(field[i][j] == -1) {
					field[i][j] = ++islandCnt;
					bfs(i, j);
				}
			}
		}
		
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<M; j++) {
//				System.out.print(field[i][j]);
//			}
//			System.out.println();
//		}
		
		//dfs로 다리 찾기(인자: from, r, c, direction, depth) 
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(field[i][j] == 0) continue;
				for(int k =0; k<4; k++) {
					dfs(field[i][j], i, j, k, 0);
				}
			}
		}
		
//		for(Edge e : edgeList) {
//			System.out.println(e.from + " " + e.to + " " + e.weight);
//		}
		
		//찾은 다리(edge)에 대해서 크루스칼로 MST 만들기
		Collections.sort(edgeList);
				
		make();
		
//		System.out.println(Arrays.toString(parents));
		
		int result = 0;
		int count = 0;
		for(Edge edge: edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count==islandCnt-1) {
					System.out.println(result);
					return;
				};
			}
		}

		System.out.println(-1);
	}
	
	static boolean isPossible(int r, int c) {
		if(r<0 || r>= N || c<0 || c>=M) {
			return false;
		}
		return true;
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		
		int[] now;
		int nr, nc;
		while(!queue.isEmpty()) {
			now = queue.poll();
			for(int i = 0; i<4; i++) {
				nr = now[0]+dir[i][0];
				nc = now[1]+dir[i][1];
				
				if(!isPossible(nr, nc) || field[nr][nc] >= 0) {
					continue;
				}
				field[nr][nc] = islandCnt;
				queue.offer(new int[] {nr, nc});
			}
		}
	}
	
	static void dfs(int from, int r, int c, int d, int l) {
		int nr = r+dir[d][0];
		int nc = c+dir[d][1];
		
		if(!isPossible(nr, nc)) {
			return;
		}
		
		if(field[nr][nc] != 0) {
			if(l < 2) return;
			if(field[nr][nc] == field[r][c]) return;
			edgeList.add(new Edge(from, field[nr][nc], l));
			
			return;
		}
		
		dfs(from, nr, nc, d, l+1);
	}
	
	static void make() {
		parents = new int[islandCnt+1];
		for(int i = 0; i<=islandCnt; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
}