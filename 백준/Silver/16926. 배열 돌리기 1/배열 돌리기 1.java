import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            String[][] array = new String[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    array[i][j] = st.nextToken();
                }
            }

            rotate(array, R);

            bw.write(toString(array));

            bw.flush();
        }
    }

    private static String toString(String[][] array) {
        StringBuilder sb = new StringBuilder();
        for (String[] row : array) {
            for (String col : row) {
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static void rotate(String[][] array, int cnt) {
        for (int i = 0; i < cnt; i++) {
            rotate(array);
        }
    }

    private static void rotate(String[][] array) {
        int orbit = Math.min(array.length, array[0].length) / 2;

        for (int i = 0; i < orbit; i++) {
            String temp = array[i][i];

            // 상단 가로
            for (int j = i + 1; j < array[i].length - i; j++) {
                array[i][j - 1] = array[i][j];
            }

            // 우측 세로
            for (int j = i + 1; j < array.length - i; j++) {
                array[j - 1][array[i].length - i - 1] = array[j][array[i].length - i - 1];
            }

            // 하단 가로
            for (int j = array[i].length - i - 1; j > i; j--) {
                array[array.length - i - 1][j] = array[array.length - i - 1][j - 1];
            }

            // 좌측 세로
            for (int j = array.length - i - 1; j > i; j--) {
                array[j][i] = array[j - 1][i];
            }

            array[i + 1][i] = temp;
        }
    }
}
