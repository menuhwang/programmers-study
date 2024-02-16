import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] code;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            String raw = br.readLine();
            code = new int[raw.length() + 1];
            for (int i = 0; i < raw.length(); i++) {
                code[i + 1] = raw.charAt(i) - '0';
            }

            dp = new int[code.length + 1];
            dp[0] = 1;

            for (int i = 1; i < code.length; i++) {
                int twoDigits = subTwoDigitsInt(i);
                if (twoDigits == 0) {
                    break;
                }

                if (canOneDigitCode(twoDigits)) {
                    dp[i] += dp[i - 1];
                }
                if (canTwoDigitsCode(twoDigits)) {
                    dp[i] += dp[i - 2];
                }
                dp[i] %= 1_000_000;
            }

            bw.write(dp[code.length - 1] + "\n");

            bw.flush();
        }
    }

    private static int subTwoDigitsInt(int end) {
        return code[end - 1] * 10 + code[end];
    }

    private static boolean canOneDigitCode(int num) {
        return num % 10 != 0;
    }

    private static boolean canTwoDigitsCode(int num) {
        return num >= 10 && num <= 26;
    }
}
