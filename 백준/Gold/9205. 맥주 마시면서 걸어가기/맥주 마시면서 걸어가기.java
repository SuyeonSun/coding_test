import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        ArrayList<Point> a; 
        boolean[][] isSearch;
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
 
            a = new ArrayList<>();
            
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
 
                a.add(new Point(x, y));
            }
            
            isSearch = new boolean[N + 2][N + 2];
            
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (Manhattan(a.get(i), a.get(j)) <= 1000) {
                        isSearch[i][j] = isSearch[j][i] = true;
                    }
                }
            }
            
            fload(isSearch, N);
            
            sb.append((isSearch[0][N + 1] ? "happy" : "sad") + '\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int Manhattan(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    public static void fload(boolean[][] isSearch, int N) {
        for(int k = 0; k < N + 2; k++) {
            for(int i = 0; i < N + 2; i++) {
                for(int j = 0; j < N + 2; j++) {
                    if(isSearch[i][k] && isSearch[k][j]) {
                        isSearch[i][j] = true;
                    }
                }
            }
        }
    }
 
}