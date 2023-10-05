import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());

            bw.write(factorial(N) + "\n");

            bw.flush();
        }
    }

    private static int factorial(int n) {
        if (n < 1) return 1;
        return factorial(n - 1) * n;
    }
}
