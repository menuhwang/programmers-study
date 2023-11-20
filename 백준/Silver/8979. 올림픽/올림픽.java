import java.io.*;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            PriorityQueue<Country> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int gold = Integer.parseInt(st.nextToken());
                int silver = Integer.parseInt(st.nextToken());
                int bronze = Integer.parseInt(st.nextToken());

                pq.offer(new Country(id, gold, silver, bronze));
            }

            int rank = 0;
            int ties = 1;
            Country prev = null;
            while (!pq.isEmpty()) {
                Country curr = pq.poll();

                if (Objects.nonNull(prev) && curr.compareTo(prev) == 0) {
                    ties++;
                } else {
                    rank += ties;
                    ties = 1;
                }

                if (curr.id == K) {
                    bw.write(rank + "\n");
                    break;
                }

                prev = curr;
            }

            bw.flush();
        }
    }

    static class Country implements Comparable<Country> {
        int id;
        int gold;
        int silver;
        int bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            int result = Integer.compare(this.gold, o.gold);
            if (result != 0) return result;

            result = Integer.compare(this.silver, o.silver);
            if (result != 0) return result;

            result = Integer.compare(this.bronze, o.bronze);

            return result;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "id=" + id +
                    ", gold=" + gold +
                    ", silver=" + silver +
                    ", bronze=" + bronze +
                    '}';
        }

    }
}
