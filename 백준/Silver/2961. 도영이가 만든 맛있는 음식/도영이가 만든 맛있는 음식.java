import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int num;
	static int[][] arr;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;
	
	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(in.readLine());
		arr = new int[num][2];
		isSelected = new boolean[num];
		
		for (int i = 0; i < num; i++) {
			String[] input = in.readLine().split(" ");
			arr[i][0] = Integer.parseInt(input[0]);
			arr[i][1] = Integer.parseInt(input[1]);
		}
		
		generateSubset(0);
		System.out.println(min);
	}
	
	public static void generateSubset(int cnt) {
		if (cnt == num) {
			int sour = 1;
			int bitter = 0;
			int isSelectedCnt = 0;
			for (int i = 0; i < num; i++) {
				if (isSelected[i]) {
					sour *= arr[i][0];
					bitter += arr[i][1];
					isSelectedCnt++;
				}
			}
			if (isSelectedCnt == 0) return;
			int diff = Math.abs(sour - bitter);
			if (diff < min) min = diff;
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}