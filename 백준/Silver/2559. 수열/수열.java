import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] memo = new int[N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 1; i <= N; i++) {
            memo[i] = memo[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MIN_VALUE;
        
        for (int i = K; i <= N; i++) {
            answer = Math.max(answer, memo[i] - memo[i - K]);
        }
        
        System.out.print(answer);
    }
}