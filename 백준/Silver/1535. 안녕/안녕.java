import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] pList = new int[N];
        int[] jList = new int[N];

        StringTokenizer st= new StringTokenizer(in.readLine());

        // 소모 체력
        for (int i = 0; i < N; i++) {
            pList[i] = Integer.parseInt(st.nextToken());
        }
        // 기쁨
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            
            jList[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[100];

        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= pList[i]; j--) {
                dp[j] = Math.max(dp[j-pList[i]] + jList[i], dp[j]);
            }
        }

        System.out.println(dp[99]);
    }
}