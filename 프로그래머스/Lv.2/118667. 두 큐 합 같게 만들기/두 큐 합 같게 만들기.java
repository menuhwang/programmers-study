import java.util.*;

class Solution {
    public int solution(int[] numbers1, int[] numbers2) {
        long sum1 = 0L;
        Queue<Integer> q1 = new LinkedList<>();
        for (int num : numbers1) {
            sum1 += num;
            q1.offer(num);
        }
        
        long sum2 = 0L;
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : numbers2) {
            sum2 += num;
            q2.offer(num);
        }
        
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        long target = (sum1 + sum2) / 2;
        for (int num : numbers1) {
            if (num > target) {
                return -1;
            }
        }
        
        for (int num : numbers2) {
            if (num > target) {
                return -1;
            }
        }
        
        int limit = (numbers1.length + numbers2.length) * 2;
        int answer = 0;
        while (sum1 != sum2 && answer < limit) {
            if (sum1 > sum2) {
                int num = q1.poll();
                sum1 -= num;
                q2.offer(num);
                sum2 += num;
            } else {
                int num = q2.poll();
                sum2 -= num;
                q1.offer(num);
                sum1 += num;
            }
            answer++;
        }
        
        if (answer >= limit) {
            return -1;
        }
        
        return answer;
    }
}