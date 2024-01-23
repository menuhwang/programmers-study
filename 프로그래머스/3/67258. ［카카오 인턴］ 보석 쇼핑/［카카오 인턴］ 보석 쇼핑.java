import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        
        Map<String, Integer> shopping = new HashMap<>();
        
        int start = 0;
        int end = 0;
        
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (start < gems.length) {
            while (shopping.size() < gemSet.size() && end < gems.length) {
                shopping.compute(gems[end++], (k, v) -> shopping.get(k) == null ? 1 : v + 1);
            }
            if (shopping.size() == gemSet.size() && end - start < minLen) {
                minLen = end - start;
                answer[0] = start + 1;
                answer[1] = end;
            }
            if (shopping.get(gems[start]) == 1) {
                shopping.remove(gems[start]);
            } else {
                shopping.compute(gems[start], (k, v) -> v - 1);
            }
            start++;
        }
        
        
        return answer;
    }
}