import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int[][] lab;
    private static int N;
    private static int M;
    private static int safe;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            lab = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    lab[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            addWall(0);

            bw.write(safe + "\n");

            bw.flush();
        }
    }

    // 벽 세우기
    // 바이러스 전파
    // 안전 구역 확인

    private static void addWall(int depth) {
        if (depth == 3) {
            int[][] cpLab = simulate();
            safe = Math.max(safe, countSafe(cpLab));
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] > 0) continue;

                lab[i][j] = 1;
                addWall(depth + 1);
                lab[i][j] = 0;
            }
        }
    }

    private static final int[][] DIRECTION = { // {dx, dy}
            {0, -1}, // 상
            {0, 1}, // 하
            {-1, 0}, // 좌
            {1, 0}, // 우
    };

    private static int[][] simulate() {
        int[][] cpLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            cpLab[i] = Arrays.copyOf(lab[i], lab[i].length);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cpLab[i][j] == 2) simulate(cpLab, j, i);
            }
        }

        return cpLab;
    }

    private static void simulate(int[][] cpLab, int x, int y) {
        for (int i = 0; i < DIRECTION.length; i++) {
            int nx = x + DIRECTION[i][0];
            int ny = y + DIRECTION[i][1];

            if (!isInLab(nx, ny)) continue;
            if (cpLab[ny][nx] > 0) continue;
            cpLab[ny][nx] = 2;
            simulate(cpLab, nx, ny);
        }
    }

    private static boolean isInLab(int x, int y) {
        return x > -1
                && y > -1
                && x < M
                && y < N;
    }

    private static int countSafe(int[][] cpLab) {
        int result = 0;
        for (int i = 0; i < cpLab.length; i++) {
            for (int j = 0; j < cpLab[0].length; j++) {
                if (cpLab[i][j] == 0) result++;
            }
        }

        return result;
    }
}
