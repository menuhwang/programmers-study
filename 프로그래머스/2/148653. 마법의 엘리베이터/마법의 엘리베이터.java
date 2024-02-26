class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int mod = storey % 10;
            storey /= 10;
            
            boolean up = mod > 5 || (mod == 5 && storey % 10 > 4);
        
            if (up) {
                answer += 10 - mod;
                storey += 1;
            } else {
                answer += mod;
            }
        }
        return answer;
    }
}