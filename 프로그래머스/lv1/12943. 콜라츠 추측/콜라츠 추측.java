class Solution {
    public int solution(long num) {        
        int count = 0;
        while (count < 500) {
            if (num == 1) return count;
            num = collatz(num);
            count++;
        }
        
        return -1;
    }
    
    private long collatz(long num) {
        return isEven(num) ? num / 2 : num * 3 + 1;
    }
    
    private boolean isEven(long num) {
        return num % 2 == 0;
    }
}