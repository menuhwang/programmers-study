import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int target;
        for (int i = 0; i < N; i++) {
            target = Integer.parseInt(br.readLine());
            while(true) {
                if (stack.isEmpty() || stack.peek() < target) {
                    stack.push(num++);
                    sb.append("+\n");
                    continue;
                }
                if (stack.peek() == target) {
                    stack.pop();
                    sb.append("-\n");
                }
                break;
            }
        }
        System.out.print(stack.isEmpty() ? sb.toString() : "NO");
    }
}