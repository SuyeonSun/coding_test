import java.util.*; 

class Solution {
    public static class Node {
        private int vertex;
        private int weight;
        private Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }
    
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        list = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[N+1];
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }
        
        dijkstra(1);
        
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        // System.out.println(Arrays.toString(dist));

        return answer;
    }
    
    public static void dijkstra(int v) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        
        queue.add(new Node(v, 0));
        dist[v] = 0;
        
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited[poll.vertex]) continue;
            visited[poll.vertex] = true;
            for (Node next : list[poll.vertex]) {
                if (dist[next.vertex] > poll.weight + next.weight) {
                    dist[next.vertex] = next.weight + poll.weight;
                    queue.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }
}