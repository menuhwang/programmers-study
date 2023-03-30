import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        boolean[] flag = new boolean[10001];
        Arrays.fill(flag, M, N + 1, true);
        
        flag[1] = false;
        
        for (int i = M; i <= N; i++) {
            if (!flag[i]) continue;
            if (!isPrime(i)) flag[i] = false;
            for (int j = 2; i * j <= N; j++) flag[i * j] = false;
        }
        
        int min = 100001;
        int sum = 0;
        
        for (int i = M; i <= N; i++) {
            if (flag[i]) {
                min = Math.min(min, i);
                sum += i;
            }
        }
        
        if (min > 10000) {
            bw.write(-1 + "");
        } else {
            bw.write(sum + "\n");
            bw.write(min + "");

        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
