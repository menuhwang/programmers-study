import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            String[] strings = br.readLine().split("\\*");
            String regex = "^" + strings[0] + "[a-z]*" + strings[1] + "$";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher;
            boolean match;
            for (int i = 0; i < N; i++) {
                matcher = pattern.matcher(br.readLine());
                match = matcher.matches();
                bw.write(match ? "DA\n" : "NE\n");
            }

            bw.flush();
        }
    }
}
