import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        BigInteger[] arr = new BigInteger[N+2];
        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");
        StringBuilder sb = new StringBuilder();
        if (N == 0) {
            sb.append(0);
        } else if (N == 1) {
            sb.append(1);
        } else {
            for (int i = 2; i < N+1; i++) {
                arr[i] = arr[i-2].add(arr[i-1]);
            }
            sb.append(arr[N]);
        }
        System.out.println(sb);
    }
}