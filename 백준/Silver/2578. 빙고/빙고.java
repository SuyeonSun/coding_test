import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int cnt;
	
	// 빙고 체크
	public static void bingo(int p, int q) {
		// 대각선
		if (p == q) {
			int totalX = 0;
			for (int i = 0; i < 5; i++) {
				totalX += arr[i][i];
			}
			if (totalX == 0) cnt ++;
		}
		
		if (p + q == 4) {
			int totalX = 0;
			for (int i = 0; i < 5; i++) {
				totalX += arr[i][4-i];
			}
			if (totalX == 0) cnt ++;
		}
		
		// 가로
		int totalY = 0;
		for (int i = 0; i < 5; i++) {
			totalY += arr[p][i];
		}
		if (totalY == 0) cnt ++;
		
		// 세로
		int totalZ = 0;
		for (int i = 0; i < 5; i++) {
			totalZ += arr[i][q];
		}
		if (totalZ == 0) cnt ++;

	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st;
		arr = new int[5][5];
		// 사용자 값 입력 받기
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자 값 입력 받기
		int answer = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				answer += 1;
				for (int p = 0; p < 5; p++) {
					for (int q = 0; q < 5; q++) {
						if (arr[p][q] == num) {
							arr[p][q] = 0;
							bingo(p, q);
							if (cnt >= 3) {
								System.out.println(answer);
								return;
							}
						}
					}
				}
				
			}
		}
		
	}

}