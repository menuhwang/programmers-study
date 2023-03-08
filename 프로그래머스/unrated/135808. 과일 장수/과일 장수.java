import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int pakages = score.length / m;
        if (pakages == 0) return 0;
        
        Arrays.sort(score);
        
        int answer = 0;
        for (int i = 1; i <= pakages; i++) {
            int index = score.length - i * m;
            answer += score[index] * m;
        }
        
        return answer;
    }
}