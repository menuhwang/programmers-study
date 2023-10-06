import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> done = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        done.add(begin);
        
        int depth = 0;
        loop:
        while (!queue.isEmpty()) {
            depth++;
            Queue<String> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                String next = queue.poll();
                for (String word : words) {
                    if (!done.contains(word) && isDifferentOneAndLess(next, word)) {
                        if (word.equals(target)) {
                            answer = depth;
                            break loop;
                        }
                        temp.add(word);
                        done.add(word);
                    }
                }
            }
            queue.addAll(temp);
        }
        
        return answer;
    }
    
    private boolean isDifferentOneAndLess(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        
        return diff <= 1;
    }
}