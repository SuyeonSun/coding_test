import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine().toUpperCase();
        HashMap<Character, Integer> hm = new HashMap<>();

        // 1. 알파벳 개수 세기
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hm.get(c) == null) {
                hm.put(c, 1);
            } else {
                Integer cnt = hm.get(c);
                hm.put(c, cnt + 1);
            }
        }
        
        int max = -1;
        char result = '?';

        // 2. 최댓값 찾기
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        // 3. 중복 체크
        int count = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == max) {
                count++;
            }
        }

        if (count > 1) {
            result = '?';
        }

        System.out.println(result);
	}
}
