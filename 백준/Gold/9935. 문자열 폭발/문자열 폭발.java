import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String bomb = in.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			if (stack.size() >= bomb.length()) {
				boolean isSame = true;
				for (int j = 0; j < bomb.length(); j++) {
					if (bomb.charAt(j) == stack.get(stack.size() - bomb.length() + j)) continue;
					else {
						isSame = false;
						break;
					}
				}
				
				if (isSame) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}			
		}
		
		if (stack.isEmpty()) System.out.println("FRULA");
		else {
			for (int j = 0; j < stack.size(); j++) {
				sb.append(stack.get(j));
			}
		}
		
		System.out.println(sb);
	}
}