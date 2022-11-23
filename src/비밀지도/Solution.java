package 비밀지도;

import java.util.Arrays;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]))
                                                                .replaceAll("0", " ")
                                                                .replaceAll("1", "#");
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n1 = 5;
        int[] arr01 = {9, 20, 28, 18, 11};
        int[] arr02 = {30, 1, 21, 17, 28};
        String[] result1 = solution.solution(n1, arr01, arr02);
        printAnswer(result1);
        int n2 = 6;
        int[] arr11 = {46, 33, 33 ,22, 31, 50};
        int[] arr12 = {27 ,56, 19, 14, 14, 10};
        String[] result2 = solution.solution(n2, arr11, arr12);
        printAnswer(result2);
    }

    private static void printAnswer(String[] answer) {
        for (String row : answer) {
            System.out.println(row);
        }
    }
}
