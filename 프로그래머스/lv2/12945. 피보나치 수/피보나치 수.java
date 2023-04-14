class Solution {
    int[] memo;
    public int solution(int n) {
        memo = new int[n + 1];
        return fib(n) % 1234567;
    }
    
    private int fib(int n) {
        if (memo[n] > 0L) return memo[n];
        if (n < 2) {
            memo[n] = n;
            return n;
        }
        memo[n] = (fib(n - 1) + fib(n - 2)) % 1234567;
        return memo[n];
    }
}