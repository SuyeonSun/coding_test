import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] stair = new int[301]; // 10 20 15 25 10 20
        int[] score = new int[301];
        for (int i = 1; i < N+1; i++) {
            stair[i] = sc.nextInt();
        }

        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int n = 4; n < N+1; n++) {
            score[n] = Math.max(score[n - 3] + stair[n - 1], score[n - 2]) + stair[n];
        }

        System.out.println(score[N]);
    }
}