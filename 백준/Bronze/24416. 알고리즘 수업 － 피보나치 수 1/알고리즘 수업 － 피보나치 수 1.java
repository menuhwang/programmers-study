import java.io.*;

public class Main {
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        check = new boolean[N + 1];
        check[1] = true;
        check[2] = true;

        System.out.printf("%d %d", fib(N), fibonacci(N));

        br.close();
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibonacci(int n) {
        if (check[n]) return 0;

        check[n] = true;
        return fibonacci(n - 1) + fibonacci(n - 2) + 1;
    }
}