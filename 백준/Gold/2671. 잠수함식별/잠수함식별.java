import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(str.matches("(10(0)+1+|01)+")) {
			System.out.println("SUBMARINE");
		}
		else {
			System.out.println("NOISE");
		}
	}

}