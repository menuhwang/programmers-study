package 예산;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=java
public class Solution {
    public int solution(int[] d, int budget) {
        d = Arrays.stream(d).sorted().toArray();
        int index;
        int sum = 0;
        for (index = 0; index < d.length; index++) {
            sum += d[index];
            if (sum > budget) break;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[]{1,3,2,5,4}, 9);
        System.out.println(answer);
        answer = solution.solution(new int[]{2,2,3,3}, 10);
        System.out.println(answer);
    }
}
