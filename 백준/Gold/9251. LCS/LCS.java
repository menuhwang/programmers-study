import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            char[] chars1 = br.readLine().toCharArray();
            char[] chars2 = br.readLine().toCharArray();

            bw.write(lcs(chars1, chars2) + "\n");

            bw.flush();
        }
    }

    private static int lcs(char[] chars1, char[] chars2) {
        int[][] dp;
        dp = new int[chars2.length + 1][chars1.length + 1];

        for (int i = 1; i <= chars2.length; i++) {
            for (int j = 1; j <= chars1.length; j++) {
                if (chars2[i - 1] == chars1[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[chars2.length][chars1.length];
    }
}
