import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    
    static boolean[][] matrix = new boolean[50][50];
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int K;

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            // 배추 위치 초기화
            int x;
            int y;
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                matrix[y][x] = true;
            }
            
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j]) {
                        count++;
                        dfs(j, i);
                    }
                }
            }
            
            bw.write(count + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void dfs(int x, int y) {
        matrix[y][x] = false;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOnMatrix(nx, ny) && matrix[ny][nx]) dfs(nx, ny);
        }
    }
    
    private static boolean isOnMatrix(int x, int y) {
        return x < M
            && y < N
            && x > -1
            && y > -1;
    }
}