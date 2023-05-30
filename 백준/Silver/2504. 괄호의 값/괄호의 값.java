import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int temp = 1;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (stack.isEmpty() || isOpen(ch)) {
                if (isClose(ch)) {
                    answer = 0;
                    break;
                }
                stack.push(ch);
                temp *= ch == '(' ? 2 : 3;
            } else {
                char peek = stack.peek();
                if (!isPair(ch, peek)) {
                    answer = 0;
                    break;
                }
                if (isPair(ch, str.charAt(i - 1))) {
                    answer += temp;
                }
                temp /= ch == ')' ? 2 : 3;
                stack.pop();
            }
        }

        if (!stack.isEmpty()) answer = 0;

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isPair(char a, char b) {
        return a == '(' && b == ')'
            || a == ')' && b == '('
            || a == '[' && b == ']'
            || a == ']' && b == '[';
    }

    private static boolean isOpen(char a) {
        return a == '(' || a == '[';
    }

    private static boolean isClose(char a) {
        return a == ')' || a == ']';
    }
}