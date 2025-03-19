import java.util.*;
import java.io.*;

public class Main {
   
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] wine = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            wine[i] = Integer.parseInt(in.readLine());
        }

        int[] dp = new int[n + 1];

        if(n >= 1) dp[1] = wine[1];
        if(n>=2) dp[2] = wine[1] + wine[2];

        for(int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], // 현재 잔 안 마심
                        Math.max(dp[i - 2] + wine[i], // 전 잔 안 마시고 현재 마심
                                 dp[i - 3] + wine[i - 1] + wine[i])); // 전전 잔 안 마시고 전+현재 마심
        }
        System.out.println(dp[n]);
    }
}
