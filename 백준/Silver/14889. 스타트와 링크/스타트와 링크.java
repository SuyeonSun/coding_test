import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int R;
	static int[][] arr;
	static int[] numbersA;
	static int min = Integer.MAX_VALUE;
	
	public static void combination(int start, int cnt) {
		if (cnt == R) {
			// 뽑은 수 배열인 numbersA, 뽑지 않은 수 배열인 numbersB
			int[] numbersB = new int[R];
			boolean[] visited = new boolean[N];
			
			for (int i = 0; i < R; i++) {
				visited[numbersA[i]] = true;
			}
			
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					numbersB[idx] = i;
					idx++;
				}
			}

			int totalA = 0;
			for (int i = 0; i < R; i++) { 
				for (int j = 0; j < R; j++) {
					if (i == j) continue;
					totalA += arr[numbersA[i]][numbersA[j]];
				}
			}
			int totalB = 0;
			for (int i = 0; i < R; i++) { 
				for (int j = 0; j < R; j++) {
					if (i == j) continue;
					totalB += arr[numbersB[i]][numbersB[j]];
				}
			}
			
			int diff = Math.abs(totalA - totalB);
			if (diff < min) min = diff;
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbersA[cnt] = i;
			combination(i+1, cnt+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		R = N / 2;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		numbersA = new int[R];
		combination(0, 0);
		
		System.out.println(min);
	}
}