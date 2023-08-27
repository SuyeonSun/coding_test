import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				char c = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				
				// n을 트리맵에 삽입
				if (c == 'I') {
					map.put(n, map.getOrDefault(n, 0) + 1);
				}
				// map이 비어있는 경우
				else if (map.size() == 0) continue;
				// 최댓값 또는 회솟값 삭제
				else {
					int key = n == 1 ? map.lastKey() : map.firstKey();
					int cnt = map.get(key);
					
					if (cnt == 1) {
						map.remove(key);
					} else {
						map.put(key, cnt - 1);
					}
				}
			}
			
			// 결과 출력
			if (map.size() == 0) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}

}