import java.util.*;

class Solution {
    public long solution(long n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        while (n > 0) {
            queue.offer((int)(n % 10));
            n /= 10;
        }
        long answer = 0;
        int size = queue.size();
        for (int i = size; i > 0; i--) {
            answer += queue.poll() * Math.pow(10, i - 1);
        }
        return answer;
    }
}