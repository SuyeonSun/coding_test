class Solution {
    private static int answer = 0;
    
    private void dfs(int[] numbers, int target, int depth, int total) {
        if (depth == numbers.length) {
            if (total == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, depth+1, total+numbers[depth]);
        dfs(numbers, target, depth+1, total-numbers[depth]);
    }
    
    public int solution(int[] numbers, int target) {        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
}