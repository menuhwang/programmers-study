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

            Set<String> dSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                dSet.add(br.readLine());
            }

            Set<String> bSet = new HashSet<>();
            for (int i = 0; i < M; i++) {
                bSet.add(br.readLine());
            }

            Set<String> dbSet = new HashSet<>(dSet);
            dbSet.retainAll(bSet);

            List<String> dbList = new ArrayList<>(dbSet);
            Collections.sort(dbList);
            
            bw.write(dbList.size() + "\n");
            for (String db : dbList)
                bw.write(db + "\n");

            bw.flush();
        }
    }
}
