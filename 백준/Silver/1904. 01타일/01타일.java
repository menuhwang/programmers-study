import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> MEMO;

    static {
        MEMO = new ArrayList<>();
        MEMO.add(0);
        MEMO.add(1);
        MEMO.add(2);
    }

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());

            while(MEMO.size() < N + 1) {
                MEMO.add((MEMO.get(MEMO.size() - 1) + MEMO.get(MEMO.size() - 2)) % 15746);
            }

            bw.write(MEMO.get(N) + "\n");
            bw.flush();
        }
    }
}
