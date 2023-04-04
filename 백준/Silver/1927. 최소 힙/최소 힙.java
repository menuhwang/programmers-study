import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int num;
        
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                Integer poll = pq.poll();
                bw.write((poll != null ? poll : 0) + "\n");
                continue;
            }
            
            pq.offer(num);
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}