class Solution {
    int solution(int[][] land) {
        for (int r = 1; r < land.length; r++) {
            int[] prevRow = land[r - 1];
            int[] currRow = land[r];
            
            for (int c = 0; c < 4; c++) {
                int max = 0;
                for (int prc = 0; prc < 4; prc++) { // previous Row Column
                    if (c == prc) continue;
                    max = Math.max(max, prevRow[prc]);
                }
                currRow[c] += max;
            }
        }

        int answer = 0;
        for (int c = 0; c < 4; c++) {
            answer = Math.max(answer, land[land.length - 1][c]);
        }
        
        return answer;
    }
}