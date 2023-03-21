class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = 0;
        while (index < section.length) {
            int coverage = section[index] + m - 1;
            while (index < section.length && section[index] <= coverage) {
                index++;
            }
            answer++;
        }
        return answer;
    }
}