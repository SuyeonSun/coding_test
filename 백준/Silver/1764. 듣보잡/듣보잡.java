import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// int cnt = 0;
		HashMap<String, Integer> hm = new HashMap<>();
		ArrayList<String> answer = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String name = in.readLine();
			hm.put(name, 1);
		}
		
		// StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String name = in.readLine();
			if (hm.get(name) != null) {
				answer.add(name);
				// sb.append(name + "\n");
				// cnt++;
			}
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		for (String name : answer) {
			System.out.println(name);
		}
	}

}