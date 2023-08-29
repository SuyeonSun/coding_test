import java.util.Scanner;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[1000001];
		arr[1] = 0;
		arr[2] = 1;
		for(int i = 3; i<=N; i++) {
			int t1 = Integer.MAX_VALUE, t2 = Integer.MAX_VALUE, t3;
			if(i % 3 == 0) {
				t1 = arr[i/3]+1;
			}
			if(i % 2 == 0) {
				t2 = arr[i/2]+1;
			}
			t3 = arr[i-1]+1;
			
			arr[i] = Math.min(t1, Math.min(t2, t3));
		}
		System.out.println(arr[N]);
	}

}