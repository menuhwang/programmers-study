import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static boolean[][] matrix;
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        matrix = new boolean[N][N];
        
        PriorityQueue<Integer> apt = new PriorityQueue<>();
        
        String line;
        
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int c = 0; c < line.length(); c++) {
                matrix[i][c] = line.charAt(c) == '1';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j]) {
                    count = 0;
                    dfs(i, j);
                    apt.add(count);
                }
            }
        }
        
        int size = apt.size();
        
        bw.write(size + "\n");
        for (int i = 0; i < size; i++) {
            bw.write(apt.poll() + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void dfs(int x, int y) {
        matrix[x][y] = false;
        count++;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOnOfMatrix(nx, ny) && matrix[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
    
    private static boolean isOnOfMatrix(int x, int y) {
        return x < matrix.length
            && y < matrix.length
            && x > -1
            && y > -1;
    }
}