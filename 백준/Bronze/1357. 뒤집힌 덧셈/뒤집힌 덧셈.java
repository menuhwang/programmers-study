import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


        bw.write(rev(rev(X) + rev(Y)) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    // 자리수 뒤집기
    private static int rev(int n) {
        // n의 자리수를 구한다.
        int digit = (int) Math.log10(n);
        int result = 0;
        // 10으로 나눈 나머지 * 10^(자리수--) 계산한 값을 결과값에 더한다.
        while (digit >= 0) {
            result += (n % 10) * (int) Math.pow(10, digit);
            digit--;
            n /= 10;
        }
        return result;
    }
}