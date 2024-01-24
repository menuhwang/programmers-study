import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            List<Position> positions = new ArrayList<>();

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                positions.add(new Position(x, y));
            }

            Collections.sort(positions);

            for (Position pos : positions) {
                bw.write(pos + "\n");
            }

            bw.flush();
        }
    }

    static class Position implements Comparable<Position> {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Position p) {
            int result = Integer.compare(this.x, p.x);
            if (result == 0) {
                result = Integer.compare(this.y, p.y);
            }
            return result;
        }
    }
}
