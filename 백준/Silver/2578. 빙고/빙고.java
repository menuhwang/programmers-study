import java.io.*;
import java.util.*;

public class Main {
    private static final int ROW = 5;
    private static final int COL = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] board = new int[ROW][COL];
        boolean[][] mask = new boolean[ROW][COL];
        
        int[] input = new int[ROW * COL];
        
        StringTokenizer st;
        for (int r = 0; r < ROW; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < COL; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int r = 0; r < ROW; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < COL; c++) {
                input[r * 5 + c] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < input.length; i++) {
            check(board, mask, input[i]);
            if (verify(mask) > 2) {
                System.out.print(i + 1);
                break;
            }
        }
    }
    
    private static void check(int[][] board, boolean[][] mask, int num) {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (num == board[r][c]) {
                    mask[r][c] = true;
                    break;
                }
            }
        }
    }
    
    private static int verify(boolean[][] mask) {
        int count = 0;
        boolean flag;
        
        for (int r = 0; r < ROW; r++) { // 가로
            flag = true;
            for (int c = 0; c < COL; c++) {
                flag &= mask[r][c];
            }
            if (flag) count++;
        }
        
        for (int c = 0; c < COL; c++) { // 세로
            flag = true;
            for (int r = 0; r < ROW; r++) {
                flag &= mask[r][c];
            }
            if (flag) count++;
        }
        
        flag = true;
        for (int i = 0; i < ROW; i++) { // 대각선1
            flag &= mask[i][i];
        }
        if (flag) count++;
        
        flag = true;
        for (int i = 0; i < ROW; i++) { // 대각선2
            flag &= mask[i][ROW - 1 - i];
        }
        if (flag) count++;
        
        return count;
    }
}
