import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, d, k, c;
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[n];
		int[] visited = new int[d+1];
		
		for(int i = 0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		for(int i = 0; i<k; i++) {
			if(visited[sushi[i]] == 0) {
				count++;
			}
			visited[sushi[i]]++;
		}
		
		int max = count;
		
		for(int i = 0; i<n; i++) {
			if(max <= count) {
				if(visited[c] == 0) {// 쿠폰 안먹음
					max = count + 1;
				}
				else {
					max = count;
				}
			}
			
			visited[sushi[i]]--;
			if(visited[sushi[i]] == 0) count--;
			
			if(visited[sushi[(i+k)%n]]==0) count++;
			visited[sushi[(i+k)%n]]++;
		}
		
		System.out.println(max);
	}

}
