package 모의고사;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] pattern = {pattern1, pattern2, pattern3};

        int[] points = new int[3];

        int maxCnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == pattern[i][j % pattern[i].length]) points[i]++;
            }
            if (points[i] > maxCnt) maxCnt = points[i];
        }

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if (maxCnt == points[i]) answerList.add(i+1);
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
