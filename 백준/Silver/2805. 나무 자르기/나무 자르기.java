import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int h = arr[arr.length-1];
		int total = 0;
		while (total < M) {
			total = 0;
			for (int i = arr.length-1; i >= 0; i--) {
				if (arr[i] - h < 0) break;
				total += (arr[i]-h);
			}
			if (total < M) h--;
		}
		System.out.println(h);
	}

}