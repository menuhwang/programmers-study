import java.util.*;

class Solution {
    static boolean[] check;
    static Set<String> nums = new HashSet<>();
    
    public long solution(String numbers) {
        String[] cards = numbers.split("");
        check = new boolean[cards.length];
        
        dfs("", cards);
        
        return nums.stream()
            .mapToInt(Integer::parseInt)
            .distinct()
            .filter(this::isPrime)
            .count();
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