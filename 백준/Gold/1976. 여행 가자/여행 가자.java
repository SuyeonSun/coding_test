import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] parents;
	
	public static void make() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot < bRoot) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// 입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        make();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	for (int j = 0; j < N; j++) {
        		int p = Integer.parseInt(st.nextToken());
        		if (p == 1) {
        			union(i, j);
        		}
        	}
        }
        
        st = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 1; i < M; i++) {
        	int stop = Integer.parseInt(st.nextToken()) - 1;
        	if (find(start) != find(stop)) {
        		System.out.println("NO");
        		return;
        	}
        }
        System.out.println("YES");
        
	}

}