import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = in.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        
        String[] arr = in.readLine().split(" ");
        
        int cnt = 0;
        
        for (int i = 0; i < arr.length; i++) {
        	int total = 0;
        	for (int j = i; j < arr.length; j++) {
        		if (total < m) total += Integer.parseInt(arr[j]);
        		if (total == m) {
        			cnt ++;
        			break;
        		}
        		if (total > m) break;
        	}
        }
        
        System.out.println(cnt);
    }
}
