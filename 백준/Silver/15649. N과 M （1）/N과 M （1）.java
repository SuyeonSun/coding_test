import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] numbers;
    static boolean[] isVisited;

    public static void combination(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            numbers[cnt] = i+1;
            isVisited[i] = true;
            combination(cnt+1);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        isVisited = new boolean[N];
        combination(0);
    }
}