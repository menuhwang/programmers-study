import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 10;
        // 먹기 전 점수
        int prev = 0;
        // 먹은 후 점수
        int next = 0;

        // 먹은 후 점수가 100을 넘을 때까지 반복
        while (next < 100 && N-- > 0) {
            prev = next;
            next = prev + Integer.parseInt(br.readLine());
        }
        // 100이 넘으면
        br.close();
        // 100 - 먹기 전 점수와 먹은 후 점수 - 100 비교
        // 차이가 작은 값 출력
        // 같을 땐 큰 값 출력
        bw.write(100 - prev < next - 100 ? prev + "" : next + "");
        bw.flush();
        bw.close();
    }
}