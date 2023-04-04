import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        
        for (int i = 0; i < N - 1; i++) pq.poll();
        
        System.out.println(pq.poll());
        
        br.close();
    }
}