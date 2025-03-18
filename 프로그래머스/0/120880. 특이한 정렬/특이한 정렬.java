import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        for (int num: numlist) {
            list.add(num);
        }
        
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int diffA = Math.abs(a - n);
                int diffB = Math.abs(b - n);
                if (diffA != diffB) {
                    return diffA - diffB;
                } else {
                    return b - a;
                }
            }
        });
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}