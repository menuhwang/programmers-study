import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry e : map.entrySet()) queue.offer(e);
        
        int answer = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            count += queue.poll().getValue();
            answer++;
            if (count >= k) break;
        }
        return answer;
    }
}