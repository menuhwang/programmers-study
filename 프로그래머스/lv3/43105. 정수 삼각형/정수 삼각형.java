import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            int[] array = triangle[i];
            for (int j = 0; j < array.length; j++) {
                int parent1 = j == 0 ? 0 : j - 1;
                int parent2 = j == array.length - 1 ? j - 1 : j;
                array[j] = Math.max(triangle[i - 1][parent1], triangle[i - 1][parent2]) + array[j];
            }
        }
                
        int answer = 0;
        for (int num : triangle[triangle.length - 1]) {
            answer = Math.max(answer, num);
        }
        
        
        return answer;
    }
}