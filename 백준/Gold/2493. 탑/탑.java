import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
				
		int[] answer = new int[N];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = N-1; i >= 0; i--) {
			if (stack.isEmpty()) stack.push(i);
			else {
				if (arr[i] < arr[stack.peek()]) {
					stack.push(i);
				} else {	
					while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
						int idx = stack.pop();
						answer[idx] = i+1;
					}
					stack.push(i);
				}
			}
		}
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
	}

}