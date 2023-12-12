class Solution {
    // 0부터 9까지 좌표 {y,x}
    int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    //초기 위치
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    
    private int getDist(int[] pos, int num) {
        return Math.abs(pos[0] - numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                leftPos = numpadPos[num];
                answer += "L";
            }
            if (num == 3 || num == 6 || num == 9) {
                rightPos = numpadPos[num];
                answer += "R";
            }
            if (num == 2 || num == 5 || num == 8 || num == 0) {
                if (getDist(leftPos, num) > getDist(rightPos, num)) {
                    answer += "R";
                    rightPos = numpadPos[num];
                }
                if (getDist(leftPos, num) < getDist(rightPos, num)) {
                    answer += "L";
                    leftPos = numpadPos[num];
                }
                if (getDist(leftPos, num) == getDist(rightPos, num)) {
                    if (hand.equals("right")) {
                        rightPos = numpadPos[num];
                        answer += "R";
                    }
                    else {
                        leftPos = numpadPos[num];
                        answer += "L";
                    }
                }
            }
        }
        
        return answer;
    }
}
