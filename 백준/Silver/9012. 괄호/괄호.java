import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        for (int i = 0; i < N; i++) {
            stack = new Stack<>();
            String s = br.readLine();
            for (int c = 0; c < s.length(); c++) {
                char ch = s.charAt(c);
                if (stack.size() == 0 || ch == '(') {
                    stack.push(ch);
                    continue;
                }
                if (stack.peek() == ')') break;
                stack.pop();
            }
            bw.write(stack.size() == 0 ? "YES\n" : "NO\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
