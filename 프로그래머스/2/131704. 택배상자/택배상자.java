import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> tempContainer = new Stack<>();    
        int conveyor = 1;
        
        for (int i = 0; i < order.length; i++) {
            int target = order[i];
            if (!tempContainer.isEmpty() && tempContainer.peek() == target) {
                tempContainer.pop();
                answer++;
                continue;
            }
            
            if (conveyor > target) {
                break;
            }
            
            while (conveyor < target) {
                tempContainer.push(conveyor++);
            }
            
            answer++;
            conveyor++;
        }
        
        return answer;
    }
}