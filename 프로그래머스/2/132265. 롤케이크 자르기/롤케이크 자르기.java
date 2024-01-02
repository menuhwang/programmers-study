import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        Map<Integer, Integer> t1 = new HashMap<>();
        Map<Integer, Integer> t2 = new HashMap<>();
        
        for (int topping : toppings) {
            t2.compute(topping, (k, v) -> v == null ? 1 : v + 1);
        }
        
        int answer = 0;
        for (int topping : toppings) {
            t1.compute(topping, (k, v) -> v == null ? 1 : v + 1);
            t2.computeIfPresent(topping, (k, v) -> v - 1);
            if (t2.get(topping) == 0) {
                t2.remove(topping);
            }
            
            if (t1.keySet().size() == t2.keySet().size()) {
                answer++;
            }
        }
        
        return answer;
    }
}