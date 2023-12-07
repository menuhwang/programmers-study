import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final List<int[]> houses = new ArrayList<>();
    private static final List<int[]> bhc = new ArrayList<>();
    private static List<int[][]> bhcCombination;
    private static int[][] bhcCombinationTemp;

    public static void main(String[] args) throws IOException {
        try (br; bw) {

            /*
            * 1. 집만 표시 되어 있는 맵 초기화
            * 2. 치킨집 위치 리스트 초기화
            * 3. 치킨집 M개 조합 리스트 생성
            * 4. 도시의 치킨 거리 계산
            * */

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    int marker = Integer.parseInt(st.nextToken());
                    if (marker == 1)
                        houses.add(new int[]{i, j});
                    else if (marker == 2)
                        bhc.add(new int[]{i, j});
                }
            }

            bhcCombination = new ArrayList<>();
            bhcCombinationTemp = new int[M][2];

            combineBhc(0, 0);

            int min = Integer.MAX_VALUE;
            for (int[][] bhc : bhcCombination) {
                int cityBhcDistance = getCityBhcDistance(N, houses, bhc);
                min = Math.min(min, cityBhcDistance);
            }

            bw.write(min + "\n");

            bw.flush();
        }
    }

    private static void combineBhc(int depth, int begin) {
        if (depth == bhcCombinationTemp.length) {
            bhcCombination.add(bhcCombinationTemp.clone());
            return;
        }

        for (int i = begin; i < bhc.size(); i++) {
            bhcCombinationTemp[depth] = bhc.get(i);
            combineBhc(depth + 1, i + 1);
        }
    }

    private static final int[][] DIRECTIONS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static int getBhcDistance(int cityLen, int[] house, int[][] bhcs) {
        int[][] map = new int[cityLen + 1][cityLen + 1];
        for (int[] bhc : bhcs)
            map[bhc[0]][bhc[1]] = 2;

        Queue<int[]> q = new LinkedList<>();
        q.add(house);
        map[house[0]][house[1]] = -1;

        int breadth = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            breadth++;
            for (int i = 0; i < qSize; i++) {
                int[] poll = q.poll();

                int r = poll[0];
                int c = poll[1];

                for (int j = 0; j < DIRECTIONS.length; j++) {
                    int nr = r + DIRECTIONS[j][0];
                    int nc = c + DIRECTIONS[j][1];

                    if (nr < 1 || nc < 1 || nr > cityLen || nc > cityLen) // 지도 밖
                        continue;

                    if (map[nr][nc] < 0) // 이미 방문
                        continue;

                    if (map[nr][nc] == 2) // 치킨 거리
                        return breadth;

                    map[nr][nc] = -1;

                    q.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }

    private static int getCityBhcDistance(int cityLen, List<int[]> houses, int[][] bhcs) {
        int cityBhcDistance = 0;

        for (int[] house: houses)
            cityBhcDistance += getBhcDistance(cityLen, house, bhcs);

        return cityBhcDistance;
    }
}
