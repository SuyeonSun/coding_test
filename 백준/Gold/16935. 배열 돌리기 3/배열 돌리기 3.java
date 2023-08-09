import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		 for (int r = 0; r < R; r++) {
			 int O = Integer.parseInt(st.nextToken());
			 if (O == 1) number1(arr.length, arr[0].length);
				else if (O == 2) number2(arr.length, arr[0].length);
				else if (O == 3) number3(arr.length, arr[0].length);
				else if (O == 4) number4(arr.length, arr[0].length);
				else if (O == 5) number5(arr.length, arr[0].length);
				else number6(arr.length, arr[0].length);
		 }
		
		 print();

	}
	
	// 출력
	public static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// 1번 연산: 상하 반전
	public static void number1(int N, int M) {
		int[] temp;
		for (int i = 0; i < N/2; i++) {
			temp = arr[N-1-i];
			arr[N-1-i] = arr[i];
			arr[i] = temp;
		}
	}
	
	// 2. 좌우 반전
	public static void number2(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				int temp = arr[i][M - 1 - j];
				arr[i][M-1-j] = arr[i][j];
				arr[i][j] = temp;
			}
		}
	}
	
	// 3. 오른쪽 90도 회전
	public static void number3(int N, int M) {
		int[][] temp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[N-1-j][i];
			}
		}
		arr = temp;
	}
	
	// 4. 왼쪽으로 90도 회전
	public static void number4(int N, int M) {
		int[][] temp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[j][M-1-i];
			}
		}
		arr = temp;
	}
	
	// 5. 1->2, 2->3, 3->4, 4->1
	public static void number5(int N, int M) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ((0 <= i && i < N/2) && (0 <= j && j < M/2)) {
					temp[i][j + M/2] = arr[i][j];
				}
				
				if ((0 <= i && i < N/2) && (M/2 <= j && j < M)) {
					temp[i + N/2][j] = arr[i][j];
				}
				
				if ((N/2 <= i && i < N) && (M/2 <= j && j < M)) {
					temp[i][j-M/2] = arr[i][j];
				}
				
				if ((N/2 <= i && i < N) && (0 <= j && j < M/2)) {
					temp[i-N/2][j] = arr[i][j];
				}
			}
		}
		arr = temp;
	}
	
	// 6. 1->4, 4->3, 3->2, 2->1
	public static void number6(int N, int M) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ((0 <= i && i < N/2) && (0 <= j && j < M/2)) {
					temp[i + N/2][j] = arr[i][j];
				}
				
				if ((0 <= i && i < N/2) && (M/2 <= j && j < M)) {
					temp[i][j-M/2] = arr[i][j];
				}
				
				if ((N/2 <= i && i < N) && (M/2 <= j && j < M)) {
					temp[i-N/2][j] = arr[i][j];				}
				
				if ((N/2 <= i && i < N) && (0 <= j && j < M/2)) {
					temp[i][j + M/2] = arr[i][j];
				}
			}
		}
		arr = temp;
	}
	

}