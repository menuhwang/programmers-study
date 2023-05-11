import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] stats;
    static List<int[]> teams;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        teams = new ArrayList<>();

        dfs(0, 0, N / 2, new int[N / 2]);

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < teams.size() / 2; i++) {
            int temp = Math.abs(getStat(teams.get(i)) - getStat(teams.get(teams.size() - 1 - i)));
            diff = Math.min(diff, temp);
        }

        System.out.println(diff);
    }

    private static void dfs(int depth, int s, int r, int[] prefix) {
        if (depth == r) {
            teams.add(Arrays.copyOf(prefix, prefix.length));
            return;
        }
        for (int i = s; i < stats.length; i++) {
            prefix[depth] = i;
            dfs(depth + 1, i + 1, r, prefix); // 뽑은 경우
            prefix[depth] = 0; // 백 트래킹
        }
    }

    private static int getStat(int[] team) {
        int stat = 0;
        for (int i = 0; i < team.length; i++) {
            for (int j = i + 1; j < team.length; j++) {
                stat += stats[team[i]][team[j]];
                stat += stats[team[j]][team[i]];
            }
        }
        return stat;
    }
}