import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Integer[] values = map.values().toArray(Integer[]::new);
        
        Arrays.sort(values, Comparator.reverseOrder());
        
        if (values.length > 1 && values[0] == values[1]) return -1;
        
        for (int key : map.keySet()) {
            if (map.get(key) == values[0]) return key;
        }
        return 0;
    }
}