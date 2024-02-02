import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());
            for (int t = 0; t < T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                Circle c1 = new Circle(x, y, r);

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                Circle c2 = new Circle(x, y, r);

                bw.write(c1.cross(c2) + "\n");
            }

            bw.flush();
        }
    }

    static class Circle {
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public int cross(Circle c) {
            if (x == c.x && y == c.y && r == c.r) {
                return -1;
            }

            double d = Math.sqrt(Math.pow(x - c.x, 2) + Math.pow(y - c.y, 2));

            int plus = r + c.r;
            int sub = Math.abs(r - c.r);

            if (sub < d && d < plus) {
                return 2;
            }

            if (d == plus || d == sub) {
                return 1;
            }

            return 0;
        }
    }
}
