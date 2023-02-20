package level1.제일_작은_수_제거하기;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        Queue<Integer> queue = new LinkedList<>();
        int min = arr[0];
        for (int num : arr) {
            queue.offer(num);
            if (min > num) min = num;
        }
        List<Integer> answerList = new ArrayList<>();
        for (int num : queue) {
            if (min != num) answerList.add(num);
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public int[] solution2(int[] arr) { // 배열만을 사용한 풀이
        if (arr.length == 1) return new int[]{-1}; // arr 길이가 1이면 바로 [-1]을 반환.
        int min = arr[0]; // 최소값 기준 초기화
        int minCnt = 1; // 중복되는 최소값 개수 초기화
        for (int num : arr) { // 최소값 검색
            if (min > num) { // 최소값 변동
                min = num;
                minCnt = 1; // 최소값이 바뀌면 개수도 1개로 초기화
            } else if (min == num) { // 최소값과 같은 값이 나오면
                minCnt++; // 최소값 개수 증가
            }
        }
        int[] answer = new int[arr.length - minCnt]; // arr길이에서 최소값의 개수를 뺀 크기로 answer 배열 선언
        int answerIdx = 0;
        for (int i = 0; i < arr.length; i++) { // answer
            if (answerIdx == answer.length) break; // answer에 값이 가득차면 반복문 종료.
            if (arr[i] != min) { // 최소값이 아닌 값들을
                answer[answerIdx++] = arr[i]; // answer에 추가
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {4, 3, 2, 1};
        int[] result1 = solution.solution(arr1);
        System.out.println(Arrays.toString(result1));
        int[] arr2 = {3, 5, 4, 2, 6, 1, 8};
        int[] result2 = solution.solution(arr2);
        System.out.println(Arrays.toString(result2));
        int[] arr3 = {3, 5, 4, 2, 6, 1, 8, 1, 1, 1, 1};
        int[] result3 = solution.solution(arr3);
        System.out.println(Arrays.toString(result3));
    }
}
