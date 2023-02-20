package level1.완주하지_못한_선수;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            if (map.get(name) == 1) map.remove(name);
            else map.put(name, map.get(name) - 1);
        }

        return map.keySet().iterator().next();
    }
}
