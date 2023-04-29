import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        LinkedList<Character> deq = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            deq.offer(s.charAt(i));
        }
        
        for (int i = 0; i < deq.size(); i++) {
            if (validate(deq)) answer++;
            deq.offer(deq.poll());
        }
        return answer;
    }
    
    private static HashMap<Character, Character> map = new HashMap<>();
    
    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
    
    private boolean validate(List<Character> s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s) {
            if (!stack.isEmpty() && map.keySet().contains(c) && stack.peek() == map.get(c)) {
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        
        return stack.isEmpty();
    }
}