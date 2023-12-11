import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<String, String> monsterMap = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                String monster = br.readLine();
                monsterMap.put(String.valueOf(i), monster);
                monsterMap.put(monster, String.valueOf(i));
            }

            for (int i = 0; i < M; i++) {
                String question = br.readLine();
                bw.write(monsterMap.get(question) + "\n");
            }

            bw.flush();
        }
    }
}
