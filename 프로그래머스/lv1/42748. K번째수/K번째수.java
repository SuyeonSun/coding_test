import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            ArrayList<Integer> arrL = new ArrayList<>();
            for (int m = i-1; m < j; m++) {
                arrL.add(array[m]);    
            }
            Collections.sort(arrL); // 
            answer[n] = arrL.get(k-1);
            
        }
        
        return answer;
    }
}