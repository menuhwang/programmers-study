class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = n * m / gcd;
        return new int[]{gcd, lcm};
    }
    
    private int gcd(int n, int m) {
        if (n < m) return gcd(m, n);
        int mod = n % m;
        if (mod == 0) return m;
        return gcd(m, mod);
    }
}