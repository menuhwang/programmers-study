import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean[][] video;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            video = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                char[] row = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    video[i][j] = row[j] == '1';
                }
            }

            String result = compress(0, 0, N);

            bw.write(result + "\n");

            bw.flush();
        }
    }

    private static String compress(int r, int c, int len) {
        if (isCompressible(r, c, len)) {
            return video[r][c] ? "1" : "0";
        }

        int newLen = len / 2;
        String leftTop = compress(r, c, newLen);
        String rightTop = compress(r, c + newLen, newLen);
        String leftBottom = compress(r + newLen, c, newLen);
        String rightBottom = compress(r + newLen, c + newLen, newLen);

        return "(" + leftTop + rightTop + leftBottom + rightBottom + ")";
    }

    private static boolean isCompressible(int r, int c, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (video[r][c] != video[r + i][c + j])
                    return false;
            }
        }

        return true;
    }
}
