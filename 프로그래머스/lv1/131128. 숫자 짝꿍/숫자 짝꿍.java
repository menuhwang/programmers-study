import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String[] elementOfX = X.split("");
        String[] elementOfY = Y.split("");
        

        Map<Integer, Integer> countX = new HashMap<>();
        Map<Integer, Integer> countY = new HashMap<>();
                
        
        for (String x : elementOfX) {
            int key = Integer.parseInt(x);
            countX.put(key, countX.getOrDefault(key, 0) + 1);
        }
        
        for (String y : elementOfY) {
            int key = Integer.parseInt(y);
            countY.put(key, countY.getOrDefault(key, 0) + 1);
        }
        
        // 짝꿍이 0 뿐인 경우
        Set<Integer> keySetOfX = countX.keySet();
        Set<Integer> keySetOfY = countY.keySet();
        
        keySetOfX.retainAll(keySetOfY);
        
        if (keySetOfX.equals(Set.of(0))) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i > -1; i--) {
            int repeat = Math.min(countX.getOrDefault(i, 0), countY.getOrDefault(i, 0));
            for (int j = 0; j < repeat; j++) {
                sb.append(i);
            }
        }
        
        return sb.length() > 0 ? sb.toString() : "-1";
    }
}