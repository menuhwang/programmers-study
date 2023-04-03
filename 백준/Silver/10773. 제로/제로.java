import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
                continue;
            }
            stack.push(num);
        }

        int sum = stack.stream().mapToInt(Integer::valueOf).sum();

        System.out.println(sum);

        br.close();
    }
}
