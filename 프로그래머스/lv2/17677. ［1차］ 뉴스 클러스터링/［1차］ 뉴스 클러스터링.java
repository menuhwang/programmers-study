import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        HashMap<String, Integer> map1 = toMap(str1);
        HashMap<String, Integer> map2 = toMap(str2);
        
        HashMap<String, Integer> union = union(map1, map2);
        HashMap<String, Integer> inter = intersection(map1, map2);
        
        int interCnt = 0;
        int unionCnt = 0;
        
        for (int n : inter.values()) interCnt += n;
        for (int n : union.values()) unionCnt += n;
        
        return unionCnt == 0 ? 65536 : Math.floorDiv(interCnt * 65536, unionCnt);
    }
    
    private HashMap<String, Integer> toMap(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 1; i < str.length(); i++) {
            String sub = str.substring(i - 1, i + 1);
            if (!sub.matches("[A-Z]+")) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        
        return map;
    }
    
    private HashMap<String, Integer> intersection(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        Set<String> interKey = new HashSet(map1.keySet());
        interKey.retainAll(map2.keySet());
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : interKey) {
            map.put(key, Math.min(map1.get(key), map2.get(key)));
        }
        
        return map;
    }
    
    private HashMap<String, Integer> union(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        Set<String> unionKey = new HashSet(map1.keySet());
        unionKey.addAll(map2.keySet());
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String key: unionKey) {
            map.put(key, Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0)));
        }
        
        return map;
    }
}