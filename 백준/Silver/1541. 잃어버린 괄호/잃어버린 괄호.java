import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split("-");
		
		int total = 0;
		for (int i = 0; i < input.length; i++) {
			String[] temp = input[i].split("\\+");
			int tempTotal = 0;
			for (int j = 0; j < temp.length; j++) {
				tempTotal += Integer.parseInt(temp[j]);
			}
			if (i == 0) total += tempTotal;
			else total -= tempTotal;
		}
		System.out.println(total);
	}

}