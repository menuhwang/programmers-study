import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();
        String pattern = br.readLine();

        // name에서 0번 index부터 indexOf를 한다.
        int from = 0;
        int count = 0;
        // 그 값이 -1일 때까지 반복한다.
        while (from > -1) {
            // fromIndex는 indexOf의 결과 + pattern 길이로 갱신한다.
            // 찾지 못 한 경우는 -1
            int index = name.indexOf(pattern, from);
            from = index > -1 ? index + pattern.length() : -1;
            // 반복한 횟수를 카운팅 한다.
            if (from > -1) count++;
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}