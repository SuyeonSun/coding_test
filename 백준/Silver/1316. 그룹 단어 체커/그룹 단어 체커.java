import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			String str = in.readLine();
			boolean isGroupWord = true;
			for (int j = 0; j < str.length(); j++) {
				if(stack.isEmpty()) {
					stack.push(str.charAt(j));
				};
				if(stack.peek() == str.charAt(j)) continue;
				else {
					if (!stack.contains(str.charAt(j))) {
						stack.push(str.charAt(j));
					} else {
						isGroupWord = false;
						break;
					}
				}
			}
			if (isGroupWord) cnt++;
		}
		System.out.println(cnt);

	}

}