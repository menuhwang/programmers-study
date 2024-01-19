import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            String word = br.readLine();

            List<String> words = new ArrayList<>();
            for (int i = 1; i < word.length() - 1; i++) {
                StringBuilder first = new StringBuilder(word.substring(0, i)).reverse();
                for (int j = i + 1; j < word.length(); j++) {
                    StringBuilder second = new StringBuilder(word.substring(i, j)).reverse();
                    StringBuilder third = new StringBuilder(word.substring(j, word.length())).reverse();

                    third.insert(0, second)
                        .insert(0, first);

                    words.add(third.toString());
                }
            }

            Collections.sort(words);

            bw.write(words.get(0) + "\n");

            bw.flush();
        }
    }
}
