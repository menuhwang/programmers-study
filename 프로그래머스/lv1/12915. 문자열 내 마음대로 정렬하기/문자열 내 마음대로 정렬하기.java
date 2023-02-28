import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) return s1.charAt(n) - s2.charAt(n);
            int len = s1.length() > s2.length() ? s2.length() : s1.length();
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) return s1.charAt(i) - s2.charAt(i);
            }
            return 0;
        });
        
        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        
        String[] answer = new String[queue.size()];
        
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}