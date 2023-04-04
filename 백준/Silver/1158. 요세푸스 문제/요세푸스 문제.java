import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> circle = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }
        
        StringBuilder sb = new StringBuilder("<");
        
        while(!circle.isEmpty()) {
            for (int i = 1; i <= K; i++) {
                if (i != K) {
                    circle.offer(circle.poll());
                    continue;
                }
                sb.append(circle.poll());
                sb.append(", ");
            }
        }
        
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        
        System.out.println(sb.toString());
        
        br.close();
    }
}