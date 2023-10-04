import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int n, m, start;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list, student;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(in.readLine());
            m = Integer.parseInt(in.readLine());

            student = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                student.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                student.get(a).add(b);
            }

            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                visit = new boolean[n];
                start = i;
                dfs(i);
            }

            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).size() == n - 1) {
                    cnt++;
                }
            }

            System.out.println("#" + t + " " + cnt);


        }



    }

    public static void dfs(int idx) {
        if (visit[idx]) return;
        visit[idx] = true;

        if (idx != start) {
            list.get(start).add(idx + 1);
            list.get(idx).add(start + 1);
        }

        for (int i = 0; i < student.get(idx).size(); i++) {
            int x = student.get(idx).get(i);
            dfs(x);
        }
    }
}