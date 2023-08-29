import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] cost;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][3];
		int[] temp = new int[3];
		cost[0][1] = 0; cost[0][1] = 0; cost[0][2] = 0;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			temp[2] = Integer.parseInt(st.nextToken());
			cost[i][0] = Math.min(cost[i-1][1]+temp[0], cost[i-1][2]+temp[0]);
			cost[i][1] = Math.min(cost[i-1][0]+temp[1], cost[i-1][2]+temp[1]);
			cost[i][2] = Math.min(cost[i-1][0]+temp[2], cost[i-1][1]+temp[2]);
		}
		
		System.out.println(Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2])));
	}

}