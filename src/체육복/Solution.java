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
        for (int i = 1; i < n; i++) {
            if (students.get(i) == 0) answer--;
        }
        return answer;
    }
}
