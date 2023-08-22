import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] value = in.readLine().split(" ");
			arr[i][0] = Integer.parseInt(value[0]);
			arr[i][1] = Integer.parseInt(value[1]);
			arr[i][2] = Integer.parseInt(value[2]);
		}

		for (int i = 1; i < N; i++) {
			arr[i][0] = arr[i][0] + Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1] = arr[i][1] + Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2] = arr[i][2] + Math.min(arr[i-1][0], arr[i-1][1]);
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			int num = arr[N-1][i];
			if (num < ans) {
				ans = num;
			}
		}
		System.out.println(ans);
	}

}
