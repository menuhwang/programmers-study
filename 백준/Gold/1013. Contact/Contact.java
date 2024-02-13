import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final Pattern PATTERN = Pattern.compile("^(100+1+|01)+$");

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; t++) {
                Matcher m = PATTERN.matcher(br.readLine());
                bw.write(m.matches() ? "YES\n" : "NO\n");
            }

            bw.flush();
        }
    }
}
