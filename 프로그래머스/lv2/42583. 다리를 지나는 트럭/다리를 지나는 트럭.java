import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int waitingPivot = 0;
        int sec = 0;
        
        Queue<Integer> crossing = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            crossing.add(0);
        }
        
        while (!crossing.isEmpty()) {
            crossing.poll();
            sec++;
            if (waitingPivot >= truck_weights.length) continue;
            if (sum(crossing) + truck_weights[waitingPivot] <= weight) {
                crossing.offer(truck_weights[waitingPivot++]); 
            } else {
                crossing.offer(0);
            }
        }
        return sec;
    }
    
    private int sum(Collection<Integer> c) {
        int sum = 0;
        for (int n : c) sum += n;
        return sum;
    }
}