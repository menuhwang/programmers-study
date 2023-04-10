import java.io.*;
import java.util.*;

public class Main {
    static int[][][] memo = new int[21][21][21];
    
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        int a = 0;
        int b = 0;
        int c = 0;
        
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if (a == -1 && b == -1 && c == -1) break;
            write(a, b, c);
        }
        
        bw.flush();
        
        br.close();
        bw.close();
    }
    
    private static void write(int a, int b, int c) throws IOException {
        bw.write(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
    }
    
    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if (a < b && b < c) {
            if (memo[a][b][c] < 1) memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return memo[a][b][c];
        }
        
        if (memo[a][b][c] < 1) memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        
        return memo[a][b][c];
    }
}