import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] isVisited;
	static int[] numbers;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	
	public static void permutation(int cnt) {
		if (cnt == N) {
			ArrayList<Integer> route = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				route.add(numbers[i]);
			}
			route.add(numbers[0]); // 다시 돌아오는 경로 추가
			// System.out.println(route);
			
			// 여행 비용 계산
			int cost = 0;
			for (int i = 0; i < route.size()-1; i++) {
				if (arr[route.get(i)][route.get(i+1)] == 0) return;
				cost += arr[route.get(i)][route.get(i+1)];
			}
			
			// 최소 여행 비용 업데이트
			if (cost < min) min = cost;
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isVisited[i]) continue;
			numbers[cnt] = i;
			isVisited[i] = true;
			permutation(cnt+1);
			isVisited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isVisited = new boolean[N];
		numbers = new int[N];
		permutation(0);
		System.out.println(min);
	}
}