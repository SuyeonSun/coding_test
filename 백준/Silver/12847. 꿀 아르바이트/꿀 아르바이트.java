import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long total = 0;
        long max = 0;
        for (int i = 0; i < M; i++) {
        	total += arr[i];
        	max = total;
        }
        
        for (int i = 1; i < N - M + 1; i++) { // 1 ~ 3
        	total = total - arr[i - 1] + arr[i + M-1];
        	max = Math.max(max, total);
        }
        
        System.out.println(max);

	}

}