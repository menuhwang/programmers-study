class Solution {
    private int[] deliveries;
    private int[] pickups;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        this.deliveries = deliveries;
        this.pickups = pickups;
        
        n = updateLongest(n);
        
        long answer = 0L;
        while (n > 0) {
            goDelivery(cap, n);
            answer += n;

            comePickup(cap, n);
            answer += n;

            n = updateLongest(n);
        }
        
        return answer;
    }
    
    private void goDelivery(int cap, int n) {
        for (int i = n - 1; i > -1; i--) {
            if (cap == 0) break;
            int temp = deliveries[i];
            deliveries[i] = Math.max(0, temp - cap);
            cap = Math.max(0, cap - temp);
        }
    }
    
    private void comePickup(int cap, int n) {
        for (int i = n - 1; i > -1; i--) {
            if (cap == 0) break;
            int temp = pickups[i];
            pickups[i] = Math.max(0, temp - cap);
            cap = Math.max(0, cap - temp);
        }
    }
    
    private int updateLongest(int n) {
        for (int i = n - 1; i > -1; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) return i + 1;
        }
        
        return 0;
    }
}