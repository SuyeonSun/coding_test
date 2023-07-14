class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        int width = 0;
        int height = 0;
        for (int i = 1; i < total; i++) {
            if ((total % i) == 0) {
                    int x = i;
                    int y = total / i;   
                if (((x-2) * (y-2) == yellow) && x >= y) {
                    width = x;
                    height = y;
                }
            
            }
        }
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}