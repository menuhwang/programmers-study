import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count;
        for (int i = 0; i < N; i++) {
            count = 0;
            String s = br.readLine();
            for (int c = 0; c < s.length(); c++) {
                char ch = s.charAt(c);
                if (ch == '(') count++;
                else count --;
                if (count < 0) break;
            }
            bw.write(count == 0 ? "YES\n" : "NO\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
