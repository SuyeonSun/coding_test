import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] input;
	static int[][][] dp;
	
	static int[][] power = {
			{2, 2, 2, 2},
			{1, 3, 4, 3},
			{3, 1, 3, 4},
			{4, 3, 1, 3},
			{3, 4, 3, 1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String[] temp = br.readLine().split(" ");
		N = temp.length;
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		input = new int[N];
		//왼발이 input에 가는 경우 오른발이 input에 가는 경우를 나눠서 생각함.
		dp = new int[N][5][5];
		dp[0] = new int[][] {
				{0, 5000000, 5000000, 5000000, 5000000},
				{5000000,5000000,5000000,5000000,5000000},
				{5000000,5000000,5000000,5000000,5000000},
				{5000000,5000000,5000000,5000000,5000000},
				{5000000,5000000,5000000,5000000,5000000},
				{5000000,5000000,5000000,5000000,5000000}
		};
				
		for(int i = 1; i<=temp.length; i++) {
			int num = Integer.parseInt(temp[i-1]);
			if(num == 0) {
				break;
			}
			
			input[i] = num;			
			for(int j = 0; j<5; j++) {
				for(int k = 0; k<5; k++) {
					dp[i][j][k] = 5000000;
				}
			}
		}
				
		for(int i = 1; i<N; i++) {
			for(int j = 0; j<5; j++) {
				for(int k = 0; k<5; k++) {
					dp[i][input[i]][j] = Math.min(dp[i][input[i]][j], dp[i-1][k][j]+power[k][input[i]-1]);
					dp[i][j][input[i]] = Math.min(dp[i][j][input[i]], dp[i-1][j][k]+power[k][input[i]-1]);					
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<5; i++) {
			min = Math.min(min, dp[N-1][input[N-1]][i]);
			min = Math.min(min, dp[N-1][i][input[N-1]]);
		}
		System.out.println(min);
	}

}