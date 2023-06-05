import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i; j < N; j++) {
                int k = N - i - j;
                if (k < j) break;
                if (i + j > k) answer++;
            }
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}