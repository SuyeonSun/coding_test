import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0] - 1; // 배열은 0-based index
            int j = commands[idx][1];
            int k = commands[idx][2] - 1;

            // 배열 자르기
            int[] subArray = Arrays.copyOfRange(array, i, j);

            // 정렬
            Arrays.sort(subArray);

            // k번째 수 저장
            answer[idx] = subArray[k];
        }

        return answer;
    }
}
