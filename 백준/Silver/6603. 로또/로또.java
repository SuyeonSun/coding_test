import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] numbers = new int[6];
	static StringBuilder sb = new StringBuilder();
	
	public static void combination(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			numbers[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0);	
			sb.append("\n");
		}
		System.out.println(sb);
	}
}