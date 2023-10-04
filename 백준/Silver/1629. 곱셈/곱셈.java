import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(func(a, b, c));
    }

    public static long func(long a, long b, long c) {
        if (b == 0) return 1;
        if (b % 2 == 1) {
            return (a * func(a, b - 1, c)) % c;
        }
        long k = func(a, b/2, c) % c;
        return (k * k) % c;
    }
}