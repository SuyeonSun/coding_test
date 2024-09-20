import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int type = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 1);
                type++;
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        
        int num = nums.length / 2;
        
        if (type <= num) {
            answer = type;
        } else {
            answer = num;
        }
        
        return answer;
    }
}