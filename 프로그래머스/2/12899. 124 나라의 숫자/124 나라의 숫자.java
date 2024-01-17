import java.util.*;

class Solution {
    private String[] chars = {"4", "1", "2"};
    
    public String solution(int n) {
        String answer = "";
        
        while (n > 0) {
            int q = n / 3;
            int r = n % 3;
            n /= 3;
            
            answer = chars[r] + answer;
            
            if (r == 0) {
                n -= 1;
            }
        }
        
        return answer;
    }
}