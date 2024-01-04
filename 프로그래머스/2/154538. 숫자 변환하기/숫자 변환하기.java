import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Set<Integer> dp = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        q.offer(x);
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                
                if (dp.contains(num))
                    continue;
                
                dp.add(num);
                
                if (num == y) {
                    return count;
                } else if (num > y) {
                    continue;
                }
                
                int next = num * 2;
                q.offer(next);
                
                next = num * 3;
                q.offer(next);
                
                next = num + n;
                q.offer(next);
            }
            
            count++;
        }
        
        return -1;
    }
}