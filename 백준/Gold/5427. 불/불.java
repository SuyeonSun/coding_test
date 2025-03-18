import java.util.*;
import java.io.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[][] fireTime;
    static int[][] sangTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];
            sangTime = new int[h][w];
            Queue<int[]> fireQueue = new LinkedList<>();
            Queue<int[]> sangQueue = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = in.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    fireTime[i][j] = -1;
                    sangTime[i][j] = -1;
                    if (map[i][j] == '*') {
                        fireQueue.add(new int[]{i, j});
                        fireTime[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        sangQueue.add(new int[]{i, j});
                        sangTime[i][j] = 0;
                    }
                }
            }

            while (!fireQueue.isEmpty()) {
                int[] curr = fireQueue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                        if (map[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                            fireTime[nx][ny] = fireTime[x][y] + 1;
                            fireQueue.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            boolean escaped = false;
            while (!sangQueue.isEmpty()) {
                int[] curr = sangQueue.poll();
                int x = curr[0];
                int y = curr[1];

                // 탈출 조건: 가장자리
                if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
                    System.out.println(sangTime[x][y] + 1);
                    escaped = true;
                    break;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                        if (map[nx][ny] != '#' && sangTime[nx][ny] == -1) {
                            if (fireTime[nx][ny] == -1 || fireTime[nx][ny] > sangTime[x][y] + 1) {
                                sangTime[nx][ny] = sangTime[x][y] + 1;
                                sangQueue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }

            if (!escaped) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
