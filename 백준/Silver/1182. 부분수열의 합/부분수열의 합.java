import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] isSelected;
    static int cnt = 0;

    public static void subset(int c) {
        if (c == N) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    total += arr[i];
                }
            }
            if (total == S) cnt++;
            return;
        }

        isSelected[c] = true;
        subset(c+1);
        isSelected[c] = false;
        subset(c+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        isSelected = new boolean[N];
        subset(0);
        if (S == 0) System.out.println(cnt-1);
        else System.out.println(cnt);
    }
}