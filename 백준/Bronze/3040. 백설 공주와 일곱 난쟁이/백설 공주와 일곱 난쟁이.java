import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int N = 9;
	static int[] arr = new int[9];
	static boolean[] isSelected = new boolean[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		generateSubset(0);
	}
	
	private static void generateSubset(int cnt) { 
		if (cnt == N) {
			int total = 0;
			int dCnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					total += arr[i];
					dCnt += 1;
				}
			}
			if (dCnt == 7 && total == 100) {
				for (int i = 0; i < N; i++) {
					if (isSelected[i]) {
						System.out.println(arr[i]);
					}
				}
			}
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
		
	}
}