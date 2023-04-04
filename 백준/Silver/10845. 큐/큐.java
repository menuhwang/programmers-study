import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            int num;
            
            switch (cmd) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    deque.offer(num);
                    break;
                case "pop":
                    bw.write((deque.isEmpty() ? -1 : deque.poll()) + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    bw.write((deque.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((deque.isEmpty() ? -1 : deque.peek()) + "\n");
                    break;
                case "back":
                    bw.write((deque.isEmpty() ? -1 : deque.peekLast()) + "\n");
                    break;
                default:
                    break;
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}