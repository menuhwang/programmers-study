class Solution {
    private static long[] dp;
    public long solution(int n) {
        dp = new long[n + 1];
        return recurs(n);
    }
    
    private long recurs(int n) {
        if (dp[n] > 0) return dp[n];
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[n] = (recurs(n - 1) + recurs(n - 2)) % 1234567;
        return dp[n];
    }
}