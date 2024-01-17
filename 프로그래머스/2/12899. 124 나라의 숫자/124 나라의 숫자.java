import java.util.*;

class Solution {
    private String[] chars = {"4", "1", "2"};
    
    public String solution(int n) {
        Stack<Integer> stack = new Stack<>();
        
        while (n > 0) {
            int q = n / 3;
            int r = n % 3;
            n /= 3;
            stack.push(r);
            
            if (r == 0) {
                n -= 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(chars[stack.pop()]);
        }
        
        return sb.toString();
    }
}