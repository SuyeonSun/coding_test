import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			char[] arr = br.readLine().toCharArray();
			int k = Integer.parseInt(br.readLine());
			int[][] location = new int[26][10000];
			int ans3 = 100001, ans4 = 0;
			for(int i = 0; i<arr.length; i++) {
				int t = arr[i]-'a';
				location[t][0]++;
				int s = location[t][0];
				location[t][location[t][0]]=i;
				if(s >= k) {
					int l = location[t][s] - location[t][s-k+1]+1;
					if(l < ans3) ans3 = l;
					if(l > ans4) ans4 = l;
				}
			}
			if(ans3 == 100001 || ans4 == 0) {
				sb.append(-1).append('\n');
			}
			else {
				sb.append(ans3).append(' ').append(ans4).append('\n');
			}
		}
		System.out.println(sb);
	}

}