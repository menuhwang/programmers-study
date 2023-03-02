import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        // 정렬
        int[][] sorted = Arrays.copyOf(score, score.length);
        Arrays.sort(sorted, (arr1, arr2) -> {
            float avg1 = (float) (arr1[0] + arr1[1]) / 2;
            float avg2 = (float) (arr2[0] + arr2[1]) / 2;
            return avg2 - avg1 == 0F ? 0 : avg2 - avg1 > 0 ? 1 : -1;
        });
        
        // 등수
        Map<int[], Integer> ranks = new HashMap<>();
        ranks.put(sorted[0], 1);
        int offset = 0;
        for (int i = 1; i < sorted.length; i++) {
            int rank = ranks.get(sorted[i - 1]);
            
            float avg1 = (float) (sorted[i - 1][0] + sorted[i - 1][1]) / 2;
            float avg2 = (float) (sorted[i][0] + sorted[i][1]) / 2;
            
            if (avg1 == avg2) {
                offset++;
                ranks.put(sorted[i], rank);
            } else {
                ranks.put(sorted[i], rank + 1 + offset);
                offset = 0;
            }
        }
        
        int[] answer = new int[score.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ranks.get(score[i]);
        }
        return answer;
    }
}