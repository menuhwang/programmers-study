import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static boolean[] check;
    static Set<String> nums = new HashSet<>();
    
    public int solution(String numbers) {
        String[] cards = numbers.split("");
        check = new boolean[cards.length];
        
        dfs("", cards);
        
        Set<Integer> integer = nums.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
        
        int answer = 0;
        
        for (int n : integer) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    private void dfs(String prefix, String[] cards) {
        if (prefix.length() == cards.length) {
            nums.add(prefix);
            return;
        }
        for (int i = 0; i < cards.length; i++) {
            if (!check[i]) {
                check[i] = true;
                if (prefix.length() > 0) nums.add(prefix);
                dfs(prefix + cards[i], cards);
                check[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}