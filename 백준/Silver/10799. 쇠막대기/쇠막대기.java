import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pipe = br.readLine();

        Stack<Character> stack = new Stack<>();

        int count = 0;
        int n = 0;
        for (char ch : pipe.toCharArray()) {
            if (ch == '(') {
                n++;
                stack.push(ch);
                continue;
            }

            if (stack.peek() == '(') {
                count += --n;
            } else {
                count++;
                n--;
            }
            stack.push(ch);
        }

        System.out.println(count);

        br.close();
    }
}
