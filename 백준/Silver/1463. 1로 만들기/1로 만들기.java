import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[] di = new int[N+1];
		di[0] = 0;
		di[1] = 0;

		// 연산을 사용하는 횟수의 최솟값 -> Math.min(a, b) 사용

		// di[1] = 0
		// di[2] = 1

		// di[3] = 1
		// 3 - 1 % 2
		// 3 - 2
		// 3 - 1 - 1
		// 3 % 3

		for (int i = 2; i <= N; i++) {
			di[i] = di[i-1] + 1; // 전 값 보다는 무조건 1 더해지기 때문에
			if (i % 3 == 0) {
				di[i] = Math.min(di[i], di[i/3]+1);
			}
			if (i % 2 == 0) {
				di[i] = Math.min(di[i], di[i/2]+1);
			}
		}

		System.out.println(di[N]);
	}
}
