import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        int index = 0;
        int answer = 0;
        
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) index++;
            if (index == target) {
                answer = i;
                break;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}