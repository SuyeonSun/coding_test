import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] isSelected;
    static int ans = 0;

    public static void subSet(int cnt) {
        if (cnt == N) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    total += arr[i];
                }
            }
            if (total == S) ans++;
            return;
        }

        isSelected[cnt] = true;
        subSet(cnt+1);
        isSelected[cnt] = false;
        subSet(cnt+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        subSet(0);
        if (S == 0) System.out.println(ans-1);
        else System.out.println(ans);
    }
}