import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[][] dp = new int[elements.length + 1][elements.length + 1];
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j < elements.length + 1; j++) {
                dp[i][j] = dp[i][j - 1] + elements[(i + j - 1) % elements.length];
                set.add(dp[i][j]);
            }
        }
        
        return set.size();
    }
}