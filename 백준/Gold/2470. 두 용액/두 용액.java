import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int left;
    static int right;
    private static int[] answer = {0, 0, Integer.MAX_VALUE};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        left = 0;
        right = N-1;
        Arrays.sort(arr); // 정렬

        while(left < right) {
            int sum = arr[left] + arr[right];
            int diffTmp = Math.abs(arr[left] + arr[right]);
            if (diffTmp < answer[2]) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                answer[2] = diffTmp;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}