import java.util.*;

class Solution {
    Stack<String> stack = new Stack<>();
    public int[] solution(int n, String[] words) {
        int[] count = new int[n + 1];
        
        for (int i = 0; i < words.length; i++) {
            int person = i % n + 1;
            count[person]++;
            if (!isPossible(words[i])) {
                return new int[]{person, count[person]};
            }
            stack.add(words[i]);
        }

        return new int[]{0, 0};
    }
    
    private boolean isPossible(String word) {
        if (stack.isEmpty()) return true;
        String lastWord = stack.peek();
        return !stack.contains(word) && lastWord.charAt(lastWord.length() - 1) == word.charAt(0);
    }
}