import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // N
		int K = Integer.parseInt(st.nextToken()); // K
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 처음 k개의 숫자의 sum 구하기
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		
		// max의 초기값은 sum의 초기값으로 할당
		int max = sum;
		
		// 투 포인터를 활용하여, 하나의 인덱스 -하고 하나의 인덱스 +해서 sum 값을 변경
		for (int i = K; i < N; i++) {
			sum += arr[i];
			sum -= arr[i-K];
			if (max < sum) max = sum;
		}
		System.out.println(max);
	}
}