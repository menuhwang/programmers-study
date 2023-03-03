class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            answer = recursive(++answer);
        }
        
        return answer;
    }
    
    private int recursive(int num) {
        if (!isCurseNum(num)) return num;
        return recursive(num + 1);
    }
    
    private boolean isCurseNum(int num) {
        if (num % 3 == 0) return true;
        
        while(num > 0) {
            int mod = num % 10;
            if (mod == 3) return true;
            num /= 10;
        }
        
        return false;
    }
}