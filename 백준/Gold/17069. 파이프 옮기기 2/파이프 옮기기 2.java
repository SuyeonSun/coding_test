import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] room;
	static long[][][] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		room = new boolean[N+1][N+1];
		dp = new long[N+1][N+1][3];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				if(st.nextToken().charAt(0) == '1') {
					room[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i<=N; i++) {
			for(int j = 0; j<= 2; j++) {
				dp[0][i][j] = 0;
				dp[i][0][j] = 0;				
			}
		}
		
		dp[1][1][0] = 0;
		dp[1][1][1] = 0;
		dp[1][1][2] = 0;
		dp[1][2][0] = 1;
		dp[1][2][1] = 0;
		dp[1][2][2] = 0;
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(i==1 && j <=2) continue;
				dp[i][j][0] = (dp[i][j-1][0]+dp[i][j-1][2])*checker(i, j-1, 0);
				dp[i][j][1] = (dp[i-1][j][1]+dp[i-1][j][2])*checker(i-1, j, 1);
				dp[i][j][2] = (dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2])*checker(i-1, j-1, 2);
			}
		}
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
	}
	
	static boolean isPossible(int nr, int nc) {
		if(nr <= 0 || nr > N || nc <= 0 || nc > N) {
			return false;
		}
		if(room[nr][nc]) return false;
		return true;
	}
	
	static int checker(int r, int c, int d) {
		switch(d) {
		case 0: //가로
			if(!isPossible(r, c+1)) return 0;
			break;
		case 1: //세로
			if(!isPossible(r+1, c)) return 0;
			break;
		case 2: // 45도
			if(!isPossible(r+1, c)) return 0;
			if(!isPossible(r, c+1)) return 0;
			if(!isPossible(r+1, c+1)) return 0;
			break;
		}
		return 1;
	}
}