import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		boolean[] isPrime = new boolean[M+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i <= M; i++) {
			if(isPrime[i]) {
				for (int j = i+i; j <= M; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i = N; i < isPrime.length; i++) {
			if(isPrime[i]) System.out.println(i);
		}
	}
}