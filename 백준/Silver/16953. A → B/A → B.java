import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long B;
    private static boolean isSame = false;
    private static long min = Integer.MAX_VALUE;

    public static void recursion(long a, long cnt) {
        if (a > B) return;
        if (a == B) {
            isSame = true;
            if (cnt < min) min = cnt;
            return;
        }

        recursion(a * 2, cnt + 1);
        recursion(a * 10 + 1, cnt + 1);
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        recursion(A, 1);

        if (isSame) System.out.println(min);
        else System.out.println(-1);
    }

}