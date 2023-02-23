class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (제곱근이_정수인가(i)) answer -= i; // 제곱근이 정수인 수는 약수 개수가 홀수이다.
            else answer += i;
        }
        return answer;
    }
    
    private boolean 제곱근이_정수인가(int num) {
        return Math.sqrt(num) % 1 == 0;
    }
}