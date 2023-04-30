import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int depth = depth(N);
        int start = sigma(depth - 1) + 1;
        int end = start + depth - 1;
        int a = N - start + 1;
        int b = end - N + 1;

        if (depth % 2 == 0) System.out.printf("%d/%d", a, b);
        else System.out.printf("%d/%d", b, a);
    }

    private static int depth(int n) {
        int sum = 0;
        int i = 1;
        while (sum < n) {
            sum += i++;
        }
        return i - 1;
    }

    private static int sigma(int n) {
        if (n < 1) return 0;
        return n + sigma(n - 1);
    }
}