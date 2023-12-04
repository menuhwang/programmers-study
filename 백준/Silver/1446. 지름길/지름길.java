import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final Map<Integer, Map<Integer, Integer>> shortcut = new HashMap<>();
    private static List<Integer> points;
    private static int N;
    private static int D;

    private static int[][] map;
    private static int[] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            init();

//            // debug
//            bw.write(shortcut.toString() + "\n");
//            bw.write(points.toString() + "\n");
//            for (int[] row : map)
//                bw.write(Arrays.toString(row) + "\n");
//            //

            visited = new boolean[points.size()];
            visited[0] = true;

            dp = new int[points.size()];
            for (int i = 0; i < points.size(); i++) {
                dp[i] = map[0][i];
            }

            dijkstra();

//            // debug
//            bw.write(Arrays.toString(dp) + "\n");

            bw.write(dp[points.size() - 1] + "\n");

            bw.flush();
        }
    }

    private static void dijkstra() {
        int minCost = getMinCostIndex();
        while (minCost > -1) {
            visited[minCost] = true;
            for (int i = minCost; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[minCost] + map[minCost][i]);
            }
            minCost = getMinCostIndex();
        }
    }

    private static int getMinCostIndex() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < dp.length; i++) {
            if (!visited[i] && min > dp[i]) {
                min = dp[i];
                index = i;
            }
        }

        return index;
    }

    private static void init() throws IOException {
        // 지름길 초기화
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int departure = Integer.parseInt(st.nextToken());
            int arrival = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (arrival > D) // 역주행 할 수 없으므로 도착지를 지나는 지름길 무시
                continue;
            if (distance > arrival - departure) // 지름길 거리가 더 손해인 경우 무시
                continue;
            
            if (Objects.isNull(shortcut.get(departure)))
                shortcut.put(departure, new HashMap<>());

            if (Objects.isNull(shortcut.get(departure).get(arrival)))
                shortcut.get(departure).put(arrival, distance); // 지름길 거리 정보가 없는 경우: 입력
            else
                shortcut.get(departure) // 지름길 거리 정보가 있는 경우: 더 작은 값으로 수정
                        .put(arrival,
                                Math.min(
                                        distance,
                                        shortcut.get(departure).get(arrival)
                                )
                        );
        }

        // 거점 리스트 초기화
        // 지름길을 이용할 수 있거나 지름길을 통해 도착할 수 있는 거점 리스트 초기화
        Set<Integer> temp = new HashSet<>();
        // 지름길 리스트에 도착점과 시작점이 없는 경우도 있으므로
        temp.add(0); // 시작점 추가
        temp.add(D); // 도착점 추가
        for (int dep : shortcut.keySet()) {
            temp.add(dep); // 지름길 시작 지점
            temp.addAll(shortcut.get(dep).keySet()); // 지름길 도착 지점
        }

        points = new ArrayList<>(temp);
        Collections.sort(points); 

        // 거점 별 거리 초기화
        int pointsSize = points.size();
        map = new int[pointsSize][pointsSize];

        for (int i = 0; i < pointsSize; i++) {
            for (int j = 0; j < pointsSize; j++) {
                // 역주행
                if (i > j) {
                    map[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int departure = points.get(i);
                int arrival = points.get(j);
                // 지름길이 있는 경우
                if (Objects.nonNull(shortcut.get(departure)) && Objects.nonNull(shortcut.get(departure).get(arrival))) {
                    map[i][j] = shortcut.get(departure).get(arrival);
                    continue;
                }
                // 그 외
                map[i][j] = arrival - departure;
            }
        }
    }
}
