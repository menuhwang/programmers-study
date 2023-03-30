import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = 0;
        
        int times = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < times; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) count++;
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int n = 2; n * n <= num; n++) {
            if (num % n == 0) return false;
        }
        return true;
    }
}