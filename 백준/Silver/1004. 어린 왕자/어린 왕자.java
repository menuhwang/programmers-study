import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sx = Integer.parseInt(st.nextToken());
                int sy = Integer.parseInt(st.nextToken());
                Position startPosition = new Position(sx, sy);

                int ex = Integer.parseInt(st.nextToken());
                int ey = Integer.parseInt(st.nextToken());
                Position endPosition = new Position(ex, ey);

                int n = Integer.parseInt(br.readLine());
                List<Circle> circles = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    st = new StringTokenizer(br.readLine());
                    int cx = Integer.parseInt(st.nextToken());
                    int cy = Integer.parseInt(st.nextToken());
                    int cr = Integer.parseInt(st.nextToken());
                    circles.add(new Circle(cx, cy, cr));
                }

                int answer = 0;
                for (Circle circle : circles) {
                    if (circle.contains(startPosition) && circle.contains(endPosition))
                        continue;
                    if (circle.contains(startPosition))
                        answer++;
                    if (circle.contains(endPosition))
                        answer++;
                }

                bw.write(answer + "\n");
            }

            bw.flush();
        }
    }

    private static class Circle {
        private final int x;
        private final int y;
        private final int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public boolean contains(Position p) {
            int dx = this.x - p.x;
            int dy = this.y - p.y;
            int distanceSq = dx * dx + dy * dy;

            return distanceSq < r * r;
        }
    }

    private static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
