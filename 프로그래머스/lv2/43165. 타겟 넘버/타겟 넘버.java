class Solution {
    int[] NUMBERS;
    int TARGET;
    int ANSWER = 0;
    
    public int solution(int[] numbers, int target) {
        NUMBERS = numbers;
        TARGET = target;
        
        dfs(0, 0);
        
        return ANSWER;
    }
    
    private void dfs(int depth, int number) {
        if (depth == NUMBERS.length) {
            if (number == TARGET) ANSWER++;
            return;
        }
        dfs(depth + 1, number + NUMBERS[depth]);
        dfs(depth + 1, number - NUMBERS[depth]);
    }
}