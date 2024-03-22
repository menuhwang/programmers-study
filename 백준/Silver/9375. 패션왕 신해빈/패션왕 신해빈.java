import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());
            for (int t = 0; t < T; t++) {
                int n = Integer.parseInt(br.readLine());
                Map<String, Integer> equip = new HashMap<>();
                StringTokenizer st;
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    String name = st.nextToken();
                    String type = st.nextToken();

                    equip.compute(type, (k, v) -> v == null ? 1 : v + 1);
                }

                int result = 1;
                for (int num : equip.values()) {
                    result *= num + 1;
                }

                bw.write((result - 1) + "\n");
            }

            bw.flush();
        }
    }
}
