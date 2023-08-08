import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int[] numbers = new int[2];
	static int M;
	static int max = 0;
	
	public static void combination(int cnt, int start) {
		if (cnt == 2) {
			int total = 0;
			for (int i = 0; i < numbers.length; i++) {
				total += numbers[i];
			}
			if (total <= M) {
				if (total > max) max = total;
			}
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			numbers[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			M = sc.nextInt();
			max = 0;
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			combination(0, 0);
            if (max == 0) System.out.println("#" + test_case + " " + -1);
			else System.out.println("#" + test_case + " " + max);
		}
		
	}
}