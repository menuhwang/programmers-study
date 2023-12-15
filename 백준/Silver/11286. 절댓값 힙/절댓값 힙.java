import java.io.*;
import java.util.PriorityQueue;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
                int result = Integer.compare(Math.abs(n1), Math.abs(n2));
                if (result == 0)
                    result = Integer.compare(n1, n2);
                return result;
            });
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0) {
                    bw.write((heap.isEmpty() ? 0 : heap.poll()) + "\n");
                } else {
                    heap.offer(num);
                }
            }

            bw.flush();
        }
    }
}
