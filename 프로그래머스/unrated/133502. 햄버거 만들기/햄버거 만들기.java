import java.util.*;

class Solution {
    int[] recipe = {1, 2, 3, 1};
    
    public int solution(int[] ingredient) {
        Stack<Integer> temp = new Stack<>();
        int answer = 0;
        
        for (int ingred : ingredient) {
            temp.add(ingred);
            if (temp.size() < 4) continue;
            if (isCompleted(temp, temp.size() - 4)) {
                answer++;
                for (int i = 0; i < 4; i++) {
                    temp.pop();
                }
            }
        }
        
        return answer;
    }
    
    private boolean isCompleted(List<Integer> stack, int fromIndex) {
        for (int i = 0; i < 4; i++) {
            if (stack.get(fromIndex + i) != recipe[i]) return false;
        }
        return true;
    }
}