import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index;

        int T = Integer.parseInt(br.readLine());
        int N;
        int M;

        PriorityQueue<Integer> important;
        Queue<Document> queue;
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            important = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine(), " ");
            for (int n = 0; n < N; n++) {
                Document document = new Document(Integer.parseInt(st.nextToken()), n);
                queue.offer(document);
                important.offer(document.important);
            }

            index = 1;
            while (!queue.isEmpty()) {
                Document document = queue.poll();
                if (document.important != important.peek()) {
                    queue.offer(document);
                    continue;
                }

                if (document.index == M) break;

                important.poll();
                index++;
            }
            sb.append(index).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static class Document implements Comparable<Document> {
        int important;
        int index;

        Document(int important, int index) {
            this.important = important;
            this.index = index;
        }

        @Override
        public int compareTo(Document d) {
            return Integer.compare(important, d.important);
        }

        @Override
        public String toString() {
            return "Document{" +
                    "important=" + important +
                    ", index=" + index +
                    '}';
        }
    }
}