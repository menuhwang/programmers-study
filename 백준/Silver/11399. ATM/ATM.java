import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        PriorityQueue<Integer> list = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        int total = 0;
        for (int i = N; i > 0; i--) {
            total += list.poll() * i;
        }
        
        System.out.print(total);
        
        br.close();
    }
}