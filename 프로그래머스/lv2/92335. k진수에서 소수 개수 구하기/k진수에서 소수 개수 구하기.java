import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String[] stringOfNumbers = Integer.toString(n, k)
            .split("0");
        
        List<Long> number = new ArrayList<>();
        
        for (String stringOfNumber : stringOfNumbers) {
            if (stringOfNumber.isBlank()) continue;
            number.add(Long.parseLong(stringOfNumber));
            System.out.println(Long.parseLong(stringOfNumber));
        }
        
        int answer = 0;
        for (long num : number) {
            if (isPrim(num)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrim(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}