import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                positions.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> sortedPositions = new ArrayList<>(positions);
            Collections.sort(sortedPositions);

            List<Integer> sortedDistinctPositions = sortedPositions.stream()
                    .distinct()
                    .collect(Collectors.toList());

            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < sortedDistinctPositions.size(); i++) {
                indexMap.put(sortedDistinctPositions.get(i), i);
            }

            for (int i = 0; i < N; i++) {
                bw.write(indexMap.get(positions.get(i)) + " ");
            }

            bw.flush();
        }
    }
}
