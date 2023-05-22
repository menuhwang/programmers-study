import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<String> filenames = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            filenames.add(br.readLine());
        }

        br.close();

        int len = filenames.get(0).length();
        for (int at = 0; at < len; at++) {
            boolean flag = true;
            char ch = filenames.get(0).charAt(at);
            for (int f = 1; f < filenames.size(); f++) {
                flag &= ch == filenames.get(f).charAt(at);
            }
            bw.write(flag ? ch : '?');
        }

        bw.flush();
        bw.close();
    }
}