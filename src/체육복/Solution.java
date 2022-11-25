package 체육복;

import java.util.HashMap;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashMap<Integer, Integer> students = new HashMap<>();
        for (int i = 1; i <= n; i++) { // n명의 체육복 개수를 해시맵으로 초기화
            students.put(i, 1);
        }
        for (int student : reserve) { // 여분이 있는 학생의 체육복 개수를 +1
            students.put(student, students.get(student) + 1);
        }
        for (int student : lost) { // 도난된 학생의 체육복 개수를 -1
            students.put(student, students.get(student) - 1);
        }
        for (int i = 1; i <= n; i++) {
            if (students.get(i) == 0) { // 앞 뒤 학생 확인
                int prev = students.getOrDefault(i - 1, 1);
                int next = students.getOrDefault(i + 1, 1);
                if (prev > 1) {
                    students.put(i - 1, students.get(i - 1) - 1);
                    students.put(i, 1);
                }else if (next > 1) {
                    students.put(i + 1, students.get(i + 1) - 1);
                    students.put(i, 1);
                }
            }
        }
        int answer = n;
        for (int i = 1; i <= n; i++) {
            if (students.get(i) == 0) answer--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        int result1 = solution.solution(n1, lost1, reserve1);
        System.out.println(result1);
        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};
        int result2 = solution.solution(n2, lost2, reserve2);
        System.out.println(result2);
        int n3 = 5;
        int[] lost3 = {1, 2, 3, 4, 5};
        int[] reserve3 = {};
        int result3 = solution.solution(n3, lost3, reserve3);
        System.out.println(result3);
    }
}
