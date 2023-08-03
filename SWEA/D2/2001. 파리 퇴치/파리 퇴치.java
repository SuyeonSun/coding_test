import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];
            int max = 0;
            
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
                	arr[i][j] = sc.nextInt();
                }
            }
            
            for (int i = 0; i < N - M + 1; i++) {
            	for (int j = 0; j < N - M + 1; j++) {
                	int total = 0;
                    for (int p = 0; p < M; p++) { 
                    	for (int q = 0; q < M; q++) {
                        	total += arr[i + p][j + q]; 
                        }
                    }
                    if (total > max) max = total;
                }
            }
            
            System.out.println("#" + test_case + " " + max);
		}
        
	}
}