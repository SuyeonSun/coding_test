import java.util.*;

class Solution {
    private class State {
        private String word;
        private int cnt;
        
        private State(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    private boolean isConvertable(String cur, String next) {
        char[] curArr = cur.toCharArray();
        char[] nextArr = next.toCharArray();
        
        int diff = 0;
        for (int i = 0; i < curArr.length; i++) {
            if (curArr[i] == nextArr[i]) continue;
            else diff++;
        }
        if (diff == 1) return true;
        else return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] isVisited = new boolean[words.length];
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));
        
        while(!queue.isEmpty()) {
            State pop = queue.poll();
            
            if (pop.word.equals(target)) {
                return pop.cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (isVisited[i]) continue;
                else {
                    if (isConvertable(pop.word, words[i])) {
                        isVisited[i] = true;
                        queue.add(new State(words[i], pop.cnt+1));
                    }
                }
            }
        }
        
        
        return 0;
    }
}