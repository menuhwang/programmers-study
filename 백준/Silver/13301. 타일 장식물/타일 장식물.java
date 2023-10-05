import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Long> MEMO;

    static {
        MEMO = new ArrayList<>();
        MEMO.add(0L);
        MEMO.add(1L);
    }

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());

            while(MEMO.size() < N + 1) {
                MEMO.add(MEMO.get(MEMO.size() - 1) + MEMO.get(MEMO.size() - 2));
            }

            bw.write(MEMO.get(N) * 2 + (MEMO.get(N) + MEMO.get(N - 1)) * 2 + "\n");
            bw.flush();
        }
    }
}
