import java.util.*;

class Solution {
    private static ArrayList<String> results = new ArrayList<>(); // 값이 한개 이상
    private static boolean[] isVisited;
    
    public void dfs(int depth, String[][] tickets, String cur, String route) {
        if (depth == tickets.length) {
            results.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && tickets[i][0].equals(cur)) {
                isVisited[i] = true;
                dfs(depth+1, tickets, tickets[i][1], route + " " + tickets[i][1]);
                isVisited[i] = false;
            }
        } 
    }
    
    public String[] solution(String[][] tickets) {
        isVisited = new boolean[tickets.length];
        
        dfs(0, tickets, "ICN", "ICN"); // 시작은 항상 "ICN"
        Collections.sort(results);
        
        return results.get(0).split(" ");
    }
}