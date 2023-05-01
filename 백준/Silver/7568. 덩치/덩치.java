import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Physical> person = new ArrayList<>();

        StringTokenizer st;
        int weight;
        int height;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            person.add(new Physical(weight, height));
        }

        for (int i = 0; i < N; i++) {
            Physical p = person.get(i);
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (person.get(j).isBiggerThan(p)) rank++; // j > p ??
            }
            bw.write(rank + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Physical {
        private int weight;
        private int height;

        public Physical(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isBiggerThan(Physical other) {
            return this.weight > other.weight
                && this.height > other.height;
        }
    }
}