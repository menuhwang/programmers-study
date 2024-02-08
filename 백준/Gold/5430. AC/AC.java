import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for (int i = 0; i < T; i++) {
                String executions = br.readLine();
                int size = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine().replaceAll("[\\[|\\]]", ""), ",");

                int[] array = new int[size];
                for (int j = 0; j < size; j++) {
                    array[j] = Integer.parseInt(st.nextToken());
                }

                Ac ac = new Ac(array);

                for (char cmd : executions.toCharArray()) {
                    switch (cmd) {
                        case 'R':
                            ac.reverse();
                            break;

                        case 'D':
                            ac.delete();
                            break;
                    }
                }

                bw.write(ac + "\n");
            }

            bw.flush();
        }
    }

    static class Ac {
        private int start;
        private int end;
        private boolean forward = true;
        private final int[] array;

        public Ac(int[] array) {
            this.array = array;
            this.start = 0;
            this.end = array.length - 1;
        }

        public void reverse() {
            this.forward = !forward;
        }

        public void delete() {
            if (forward) {
                start++;
            } else {
                end--;
            }
        }

        @Override
        public String toString() {
            if (start > end + 1) {
                return "error";
            }

            StringBuilder sb = new StringBuilder("[");
            if (forward) {
                for (int i = start; i <= end; i++) {
                    sb.append(array[i]);

                    if (i != end)
                        sb.append(",");
                }
            } else {
                for (int i = end; i >= start; i--) {
                    sb.append(array[i]);

                    if (i != start)
                        sb.append(",");
                }
            }
            sb.append("]");

            return sb.toString();
        }
    }
}
