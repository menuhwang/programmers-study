import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Set<Integer> truth = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                truth.add(Integer.parseInt(st.nextToken()));
            }

            List<Set<Integer>> parties = new ArrayList<>();
            List<List<Integer>> relations = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                relations.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int participantSize = Integer.parseInt(st.nextToken());
                Set<Integer> participants = new HashSet<>();
                for (int j = 0; j < participantSize; j++) {
                    participants.add(Integer.parseInt(st.nextToken()));
                }
                parties.add(participants);

                for (int p : participants) {
                    relations.get(p).addAll(participants);
                }
            }

            boolean[] visited = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>(truth);
            while (!q.isEmpty()) {
                int t = q.poll();

                if (visited[t]) continue;

                visited[t] = true;
                q.addAll(relations.get(t));
                truth.addAll(relations.get(t));
            }

            int result = 0;
            for (Set<Integer> participants : parties) {
                if (!participants.removeAll(truth))
                    result++;
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }
}
