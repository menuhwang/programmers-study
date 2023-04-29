import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;
        for (String city : cities) {
            String CITY = city.toUpperCase();
            if (cache.contains(CITY)) {
                answer += 1;
                cache.remove(CITY);
                cache.offer(CITY);
                continue;
            } 
            answer += 5;
            if (cache.size() < cacheSize) {
                cache.offer(CITY);
            } else if (cacheSize > 0) {
                cache.poll();
                cache.offer(CITY);
            }
        }
        return answer;
    }
}