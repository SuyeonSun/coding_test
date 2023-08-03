import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.StringTokenizer;

import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
        int N, M;
        String[] input = in.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        
        
        int[][] arr = new int[N][N+1];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	for (int j = 1; j <= N; j++) {
        		arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(in.readLine());
        	int a1 = Integer.parseInt(st.nextToken())-1;
        	int b1 = Integer.parseInt(st.nextToken());
        	int a2 = Integer.parseInt(st.nextToken())-1;
        	int b2 = Integer.parseInt(st.nextToken());

        	int total = 0;
        	for (int j = a1; j <= a2; j++) {
        		total += arr[j][b2] - arr[j][b1-1];
        	}
        	sb.append(total + "\n");
        }
        System.out.println(sb);
        
    }
}