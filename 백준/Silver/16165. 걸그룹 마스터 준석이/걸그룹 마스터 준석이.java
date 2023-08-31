import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

// https://hianna.tistory.com/576

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		HashMap<String, String> hm = new HashMap<>();
		
		// N 총 입력 받을 걸그룹 수, M 맞혀야 할 문제 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String value = in.readLine(); // 팀 이름
			int total = Integer.parseInt(in.readLine()); // 인원 수
			for (int t = 0; t < total; t++) { 
				String key = in.readLine(); // 멤버 이름
				hm.put(key, value);
			}
		}
		
		// System.out.println(hm); // <name, team>
		
		// M개의 퀴즈
		// 팀 이름 or 멤버의 이름
		// 퀴즈의 종류 0 (팀의 이름) 또는 1 (멤버의 이름)
		
		// 출력: 0일 경우 해당 팀 멤버 이름 사전 순 출력
		// 출력: 1일 경우 해당 멤버가 속한 팀의 이름 출력
		for (int i = 0; i < M; i++) {
			String str = in.readLine();
			int type = Integer.parseInt(in.readLine());
			if (type == 0) {
				// 팀의 이름으로 멤버들 출력
				ArrayList<String> ans = new ArrayList<>();
				for (Entry<String, String> entry : hm.entrySet()) {
					if (entry.getValue().equals(str)) {
						ans.add(entry.getKey());
					}
				}
				Collections.sort(ans);
				for (int e = 0; e < ans.size(); e++) {
					System.out.println(ans.get(e));
				}				
			} else {
				// 멤버 이름으로 팀 출력
				for (Entry<String, String> entry : hm.entrySet()) {
					if (entry.getKey().equals(str)) {
						System.out.println(entry.getValue());
					}
				}
			}
		}
	}

}