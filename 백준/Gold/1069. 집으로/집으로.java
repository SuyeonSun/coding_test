import java.util.Scanner;

public class Main {
	static int X, Y, D, T;
	static double ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		D = sc.nextInt();
		T = sc.nextInt();
		
		double dist = Math.sqrt(X*X+Y*Y);
		int jump = (int) (dist/D);
		
		double spare = dist - jump*D;
		double result = dist;
		
		result = Math.min(result, spare+jump*T);
		
		if(jump > 0) result = Math.min(result, (jump+1)*T*1.0);
		else {
			result = Math.min(result, D-spare + T);
			if(dist < D) result = Math.min(result, T*2.0);
		}
		
		System.out.printf("%.10f\n", result);
	}
}