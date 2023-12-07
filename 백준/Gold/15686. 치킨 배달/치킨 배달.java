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
            * 1. 집 위치 리스트 초기화
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
                int cityBhcDistance = getCityBhcDistance(houses, bhc);
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

    private static int getBhcDistance(int[] house, int[][] bhcs) {
        int min = Integer.MAX_VALUE;

        for (int[] bhc : bhcs) {
            int distance = Math.abs(bhc[0] - house[0]) + Math.abs(bhc[1] - house[1]);
            min = Math.min(min, distance);
        }

        return min;
    }

    private static int getCityBhcDistance(List<int[]> houses, int[][] bhcs) {
        int cityBhcDistance = 0;

        for (int[] house: houses)
            cityBhcDistance += getBhcDistance(house, bhcs);

        return cityBhcDistance;
    }
}
