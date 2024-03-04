import java.util.*;

class Solution {

    static ArrayList<String> list = new ArrayList<>();
    static boolean isVisited[];

    public String[] solution(String[][] tickets) {
        isVisited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    static void dfs(int depth, String now, String path, String[][] tickets){
        if (depth == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && now.equals(tickets[i][0])) {
                isVisited[i] = true;
                dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
                isVisited[i] = false;
            }
        }
    }
}