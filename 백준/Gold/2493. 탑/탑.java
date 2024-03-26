import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Stack<int[]> stack = new Stack<>();
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                while (!stack.isEmpty() && stack.peek()[1] < num) {
                    stack.pop();
                }

                bw.write(stack.isEmpty() ? "0 " : stack.peek()[0] + " ");
                stack.push(new int[]{i, num});
            }

            bw.flush();
        }
    }
}
