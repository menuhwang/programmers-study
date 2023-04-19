import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = N;
        String s;
        Stack<Character> stack;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (stack.isEmpty() || !stack.contains(ch)) {
                    stack.add(ch);
                    continue;
                }
                if (stack.peek() != ch) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}