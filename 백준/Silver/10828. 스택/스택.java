import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            int num;
            
            switch (cmd) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    bw.write((stack.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "top":
                    bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
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