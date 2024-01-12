class Solution {
    private int len;
    private int[][] DIRECTIONS = {
        {-1, 0}, // 상
        {1, 0}, // 하
        {0, -1}, // 좌
        {0, 1}, // 우
    };
    
    public int solution(String[][] board, int h, int w) {
        len = board.length;
        
        int answer = 0;
        for (int[] direction : DIRECTIONS) {
            int h_check = h + direction[0];
            int w_check = w + direction[1];
            
            if (onBoard(h_check, w_check)) {
                if (board[h][w].equals(board[h_check][w_check])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private boolean onBoard(int h, int w) {
        return h > -1
            && w > -1
            && h < len
            && w < len;
    }
}