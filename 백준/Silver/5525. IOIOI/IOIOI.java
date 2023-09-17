import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        String S = in.readLine();

        String P = "I";
        for (int i = 0; i < N; i++) {
            P += "O";
            P += "I";
        }

        String[] arr = new String[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Character.toString(S.charAt(i));
        }

        int l = P.length();

        String str = "";
        for (int i = 0; i < l; i++) {
            str += arr[i];
        }

        int cnt = 0;
        if (str.equals(P)) cnt += 1;
        for (int i = l; i < M; i++) {
            // str vs P
            String newStr = str.substring(1);
            newStr += arr[i];
            str = newStr;

            if (str.equals(P)) cnt += 1;
        }

        System.out.println(cnt);
    }
}