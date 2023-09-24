import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// H W X Y
		// ... B의 원소
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[H][W];
		int[][] B = new int[H+X][W+Y];
		
		// B 입력받기
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i< H+X; i++) {
			for(int j =0; j< W+Y; j++) {
				if(i<X && j< W) {// 위쪽 안겹치는 부분
					A[i][j] = B[i][j];
				}else if(j<Y && i<H) { // 왼쪽 안겹치는 부분
					A[i][j] = B[i][j];
				}else if(j>=Y && i>=X  && j< W && i<H) {// 겹치는 부분
					A[i][j] = B[i][j]-A[i-X][j-Y];
				}
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}