import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++)
                queue.offer(i);

            while (queue.size() > 1) {
                queue.poll();
                queue.offer(queue.poll());
            }

            bw.write(queue.poll() + "");

            bw.flush();
        }
    }
}
