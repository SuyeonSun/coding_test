import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] time = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int t = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) t++;
            time[i] = t;
        }

        // stack.peek이 아니라 biggest로 수정해야 함
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < time.length; i++) {
            if (time[i] > max)  max = time[i];
            
            if (pq.isEmpty()) {
                pq.add(time[i]);
                if (i == time.length - 1) {
                    answer.add(pq.size());
                }      
            }
            else {
                if (pq.peek() < time[i]) { 
                    answer.add(pq.size());
                    pq.clear();
                    pq.add(time[i]);
                } else {
                    pq.add(time[i]);
                }

                if (i == time.length - 1) {
                    answer.add(pq.size());
                }
            }

        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}