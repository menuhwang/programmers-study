import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int L;
    private static int C;
    private static String[] chars;
    private static final List<String> list = new ArrayList<>();
    private static final Set<String> vowel = new HashSet<>(List.of("a", "e", "i", "o", "u"));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            chars = new String[C];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < C; i++) {
                chars[i] = st.nextToken();
            }
            Arrays.sort(chars);

            dfs(0, "", 0, 0);

            for (String pw : list) {
                bw.write(pw);
                bw.newLine();
            }

            bw.flush();
        }
    }

    private static void dfs(int to, String prefix, int vowelCnt, int consonantCnt) {
        if (prefix.length() == L) {
            if (validate(vowelCnt, consonantCnt))
                list.add(prefix);
            return;
        }

        for (int i = to; i < C - (L - prefix.length()) + 1; i++) {
            if (vowel.contains(chars[i]))
                dfs(i + 1, prefix + chars[i], vowelCnt + 1, consonantCnt);
            else
                dfs(i + 1, prefix + chars[i], vowelCnt, consonantCnt + 1);
        }
    }

    private static boolean validate(int vowelCnt, int consonantCnt) {
        return vowelCnt >= 1 && consonantCnt >= 2;
    }
}
