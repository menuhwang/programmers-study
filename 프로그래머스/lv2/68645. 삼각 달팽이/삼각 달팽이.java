class Solution {
    static int[][] triangle;
    static int x = 0;
    static int y = 0;
    static int num = 1;
    
    public int[] solution(int n) {
        triangle = new int[n][n];

        draw(0, n);

        int[] answer = new int[n * (n + 1) / 2];

        int index = 0;
        for (int[] row : triangle) {
            for (int num : row) {
                if (num == 0) break;
                answer[index++] = num;
            }
        }
        
        return answer;
    }
    
    private void draw(int dir, int n) {
        if (n < 1) return;
        switch (dir % 3) {
            case 0:
                for (int i = 0; i < n; i++) {
                    triangle[x++][y] = num++;
                }
                x--;
                y++;
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    triangle[x][y++] = num++;
                }
                x--;
                y--;
                y--;
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    triangle[x--][y--] = num++;
                }
                x++;
                x++;
                y++;
                break;
            default:
                break;
        }
        draw(dir + 1, n - 1);
    }
}