import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static long[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			dp= new long[N+1][10];
			
			for(int i = 1; i<10; i++) {
				dp[0][i] = 1;
			}
			int sum = 0;
			for(int i = 1; i<=N; i++) {
				dp[i][0] = 1;
				for(int j = 1; j<10; j++) {
					dp[i][j] = dp[i][j-1]+dp[i-1][j];
				}
			}
			
			sb.append(dp[N][9]).append('\n');
		}
		System.out.println(sb);
	}

}