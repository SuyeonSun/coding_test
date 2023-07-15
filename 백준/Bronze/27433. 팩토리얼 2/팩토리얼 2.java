import java.util.Scanner;

public class Main {
    static long total = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        func(number);
        System.out.println(total);
    }

    public static void func(long num) {
        if (num == 0) {
            total = 1;
            return;
        } else {
            total *= num;
            num--;
            if (num > 0) func(num);
        }
    }
}