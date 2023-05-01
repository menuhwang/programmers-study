import java.io.*;

public class Main {
    static int[] zero = new int[41];
    static int[] one = new int[41];

    static {
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int visited = 1;

        int num;
        for (int t = 0; t < T; t++) {
            num = Integer.parseInt(br.readLine());
            for (int n = 2; n <= num; n ++) {
                if (n <= visited) continue;
                visited = Math.max(visited, n);
                zero[n] = zero[n - 1] + zero[n - 2];
                one[n] = one[n - 1] + one[n - 2];
            }
            bw.write(zero[num] + " " + one[num] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}