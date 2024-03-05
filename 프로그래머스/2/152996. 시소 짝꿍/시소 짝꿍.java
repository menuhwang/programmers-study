import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> weightCnt = new HashMap<>();
        Map<Integer, Integer> torques = new HashMap<>();
        
        for (int i = 0; i < weights.length; i++) {
            int equalWeight = weightCnt.getOrDefault(weights[i], 0);
            
            for (int j = 2; j <= 4; j++) {
                answer += torques.getOrDefault(weights[i] * j, 0) - equalWeight;
            }
            
            if (equalWeight > 0) {
                answer += equalWeight;
            }
            
            weightCnt.compute(weights[i], (k, v) -> v == null ? 1 : v + 1);
            
            for (int j = 2; j <= 4; j++) {
                torques.compute(weights[i] * j, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        
        return answer;
    }
}