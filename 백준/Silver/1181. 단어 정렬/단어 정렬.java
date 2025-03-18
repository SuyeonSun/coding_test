import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            if (!list.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });        

        for (String s: list) {
            System.out.println(s);
        }
	}
}
