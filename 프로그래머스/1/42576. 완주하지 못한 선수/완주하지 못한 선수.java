import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            if (map.get(name) != null) {
                int num = map.get(name);
                num++;
                map.put(name, num);
            } else {
             map.put(name, 1);   
            }
        }
        
        for (String name : completion) {
            int num = map.get(name);
            num--;
            map.put(name, num);
        }
        
        for (String name : participant) {
            if (map.get(name) != 0) {
                answer = name;
                break;
            }
        }
        
        return answer;
    }
}