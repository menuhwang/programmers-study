class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int pivot = n / i;
            int min = pivot - i / 2;
            if (i % 2 == 0) min++;
            if (min < 1) break;
            
            int sum = pivot * i;
            if (i % 2 == 0) sum += i / 2;
            if (sum == n) answer++;
        }
        return answer;
    }
}