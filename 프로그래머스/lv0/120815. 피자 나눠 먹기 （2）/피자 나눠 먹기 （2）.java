class Solution {
    public int solution(int n) {
        return pizza(n, 1);
    }
    
    private int pizza(int people, int n) {
        if (people * n % 6 == 0) return people * n / 6;
        return pizza(people, n + 1);
    }
}