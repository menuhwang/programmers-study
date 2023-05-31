import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        A[0] = 1;

        int[] B = new int[N + 1];
        B[0] = 0;

        for (int i = 1; i < N + 1; i++) {
            B[i] = A[i - 1] + B[i - 1];
            A[i] = B[i - 1];
        }

        bw.write(A[N] + " " + B[N]);
        bw.flush();
        br.close();
        bw.close();
    }
}