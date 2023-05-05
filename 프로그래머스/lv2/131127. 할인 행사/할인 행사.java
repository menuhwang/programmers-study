import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Set<String> wantSet = new HashSet<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> discountMap;
        
        for (int i = 0; i < want.length; i++) {
            wantSet.add(want[i]);
            countMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            discountMap = getDiscountMap(Arrays.copyOfRange(discount, i, i + 10));
            if (isPossible(countMap, discountMap)) answer++;
        }
        
        return answer;
    }
    
    private Map<String, Integer> getDiscountMap(String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : discount) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        
        return map;
    }
    
    private boolean isPossible(Map<String, Integer> want, Map<String, Integer> discount) {
        if (!discount.keySet().containsAll(want.keySet())) return false;
        for (String item : want.keySet()) {
            if (want.get(item) > discount.get(item)) return false;
        }
        return true;
    }
}