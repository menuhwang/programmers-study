class Solution {
    public long solution(long n) {
        long num = isSquareRootNum(n);
        if (num > -1) return (num + 1) * (num + 1);
        return num;
    }
    
    private long isSquareRootNum(long n) {
        return Math.sqrt(n) % 1 == 0 ? (long) Math.sqrt(n) : -1L;
    }
}