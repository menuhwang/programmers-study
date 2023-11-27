import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            List<Integer> points = new ArrayList<>();
            for (int i = 0; i < 8; i++)
                points.add(Integer.parseInt(br.readLine()));

            List<Integer> sorted = new ArrayList<>(points);
            sorted.sort(Comparator.reverseOrder());

            int total = 0;
            List<Integer> question = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int point = sorted.get(i);
                total += point;
                question.add(points.indexOf(point) + 1);
            }
            question.sort(Comparator.naturalOrder());

            bw.write(total + "\n");
            for (int q : question)
                bw.write(q + " ");

            bw.flush();
        }
    }
}
