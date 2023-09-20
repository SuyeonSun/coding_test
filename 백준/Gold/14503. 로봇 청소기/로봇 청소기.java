import java.util.*;

public class Main {

    static int N, M, curX, curY, d;
    static int[][] arr;
    static int count = 1;
    static int[] dx = {-1, 0, 1, 0}; //북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        curX = scan.nextInt();
        curY = scan.nextInt();
        d = scan.nextInt();

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        dfs(curX, curY, d);
        System.out.println(count);
    }

    public static void dfs(int x, int y, int dir) {
        arr[x][y] = 2; //청소 완료

        for(int i = 0; i < 4; i++) {
            dir -= 1; // 1. 왼쪽 방향으로 돌면서 탐색
            if(dir == -1) dir = 3; // 북쪽에서 돌때는 3으로 변경

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(arr[nx][ny] == 0) { // 이동 가능하고 청소를 안했다면
                    count++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        // 사방면에 더 이상 청소할 공간이 없다면
        int d = (dir + 2) % 4; // 반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] != 1) {
            dfs(bx, by, dir); //후진할 때 방향을 유지
        }
    }
}