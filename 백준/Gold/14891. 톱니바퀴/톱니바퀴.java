import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Gear {
        private final char[] tooth;
        private int pivot;

        public Gear(String tooth) {
            this.tooth = tooth.toCharArray();
            this.pivot = 0;
        }

        /**
         * @return N극 false, S극 true
         */
        public boolean getTop() {
            return tooth[pivot] == '1';
        }

        public void rotateCW() {
            this.pivot = (pivot + tooth.length - 1) % tooth.length;
        }

        public void rotateRCW() {
            this.pivot = (pivot + 1) % tooth.length;
        }


        /**
         * @return N극 false, S극 true
         */
        public boolean getLeft() {
            int left = (pivot + tooth.length - 2) % tooth.length;
            return tooth[left] == '1';
        }

        /**
         * @return N극 false, S극 true
         */
        public boolean getRight() {
            int right = (pivot + 2) % tooth.length;
            return tooth[right] == '1';
        }
    }

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            List<Gear> gears = new ArrayList<>();
            gears.add(null);

            for (int i = 0; i < 4; i++) {
                gears.add(new Gear(br.readLine()));
            }

            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                boolean[] visited = new boolean[5];
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                rotate(gears, visited, index, dir);
            }

            int[] point = {0, 1, 2, 4, 8};
            int result = 0;
            for (int i = 1; i <= 4; i++) {
                result += gears.get(i).getTop() ? point[i] : 0;
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }

    private static void rotate(List<Gear> gears, boolean[] visited, int index, int dir) {
        Gear gear = gears.get(index);
        visited[index] = true;

        // 오른쪽 기어
        if (index < 4 && !visited[index + 1]) {
            Gear rightGear = gears.get(index + 1);
            if (gear.getRight() != rightGear.getLeft()) {
                rotate(gears, visited, index + 1, dir * -1);
            }
        }

        // 왼쪽 기어
        if (index > 1 && !visited[index - 1]) {
            Gear leftGear = gears.get(index - 1);
            if (gear.getLeft() != leftGear.getRight()) {
                rotate(gears, visited, index - 1, dir * -1);
            }
        }

        if (dir == 1) {
            gear.rotateCW();
        } else if (dir == -1) {
            gear.rotateRCW();
        }
    }
}
