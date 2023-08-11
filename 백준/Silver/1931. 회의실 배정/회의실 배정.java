import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] time = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] input = in.readLine().split(" ");
			time[i][0] = Integer.parseInt(input[0]);
			time[i][1] = Integer.parseInt(input[1]);
		}
		
		Arrays.sort(time, (o1, o2) -> {
			if (o1[1] == o2[1]) { // 종료 시간이 같다면
				return o1[0] - o2[0]; // 시작 시간이 작은 값 리턴
			}
			return o1[1]- o2[1]; // 종료 시간 오름차순
		});
		
		int cnt = 0;
		int end = 0;
		
		for (int i = 0; i < N; i++) {
			if (end <= time[i][0]) { // 현재 끝난 시간 보다 다음 시작 시간이 더 뒤라면
				end = time[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}