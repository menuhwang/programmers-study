class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int y = 3; y < 2500; y++) {
            for (int x = 3; x < 2500; x++) {
                if ((x - 2) * (y - 2) == yellow && 2 * (x + y) - 4 == brown) {
                    answer[0] = Math.max(x, y);
                    answer[1] = Math.min(x, y);
                    break;
                }
            }
        }
        return answer;
    }
}