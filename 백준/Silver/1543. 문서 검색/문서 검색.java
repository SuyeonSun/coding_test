import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		String doc = in.readLine();
		String word = in.readLine();
		
		int idx = 0;
		int cnt = 0;
		for (int i = 0; i < doc.length() - word.length() + 1; i+=idx) {
			boolean isSame = true;
			for (int j = 0; j < word.length(); j++) {
				if (doc.charAt(i+j) != word.charAt(j)) {
					isSame = false;
					break;
				}
			}
			
			if (isSame) {
				cnt++;
				idx = word.length();
			} else {
				idx = 1;
			}
		}
		System.out.println(cnt);
		
	}
}