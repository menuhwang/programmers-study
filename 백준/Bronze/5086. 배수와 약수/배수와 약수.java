import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String nl;
        while(!(nl = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(nl, " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            
            bw.write(sol(num1, num2));
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static String sol(int num1, int num2) {
        // 두 수가 같은 경우는 없다.
        int A = Math.max(num1, num2); // 큰 수
        int B = Math.min(num1, num2); // 작은 수
        
        return A % B == 0 ? num1 > num2 ? "multiple\n" : "factor\n" : "neither\n";
    }
}