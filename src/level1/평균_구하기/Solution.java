package level1.평균_구하기;

public class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for (int num : arr) {
            answer += num;
        }
        return answer / arr.length;
    }
}
