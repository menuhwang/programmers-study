import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());

            Queue<String> entrance = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                entrance.offer(br.readLine());
            }

            Set<String> offense = new HashSet<>();
            while (!entrance.isEmpty()) {
                String entranceCar = entrance.peek();

                if (offense.contains(entranceCar)) {
                    entrance.poll();
                    continue;
                }

                String exitCar = br.readLine();

                if (exitCar.equals(entranceCar)) {
                    entrance.poll();
                } else {
                    offense.add(exitCar);
                }

            }

            bw.write(offense.size() + "\n");
            bw.flush();
        }
    }
}
