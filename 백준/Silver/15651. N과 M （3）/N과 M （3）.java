import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void permutation (int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			numbers[cnt] = i + 1;
			permutation (cnt + 1);
		}
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		permutation(0);		
		System.out.println(sb);
	}
}