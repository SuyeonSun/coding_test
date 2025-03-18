import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(in.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String word = in.readLine();
            if (set.contains(word)) {
                count++;
            }
        }

        System.out.println(count);
	}
}