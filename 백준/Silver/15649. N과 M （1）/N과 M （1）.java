import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] numbers;
	static boolean[] isSelected;
	static int M;
	
	public static void permutation (int cnt) {
		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = arr[i]; 
				permutation (cnt + 1);
				isSelected[i] = false;
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		isSelected = new boolean[N];
		numbers = new int[M];		
		for (int i = 0; i < N; i++) arr[i] = i + 1;
		permutation(0);
	}
}