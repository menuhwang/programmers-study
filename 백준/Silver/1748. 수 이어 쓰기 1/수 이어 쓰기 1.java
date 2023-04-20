import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int d = (int) (Math.log10(N) + 1);
        for (int i = d - 1; i > 0; i--) {
            result += i * (int) ((Math.pow(10, i) - Math.pow(10, i - 1)));
        }
        result += d * (N - (int) Math.pow(10, d - 1) + 1);
        System.out.println(result);
        br.close();
    }
}