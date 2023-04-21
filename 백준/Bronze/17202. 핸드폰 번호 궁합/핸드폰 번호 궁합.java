import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] check = new boolean[10][10];
    static int[][] dp = new int[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String phone1 = br.readLine();
        String phone2 = br.readLine();

        StringBuilder join = new StringBuilder();

        for (int i = 0; i < 8; i ++) {
            join.append(phone1.charAt(i))
                .append(phone2.charAt(i));
        }

        System.out.println(chemistry(join));
    }

    private static String chemistry(StringBuilder sb) {
        if (sb.length() < 3) return sb.toString();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < sb.length(); i++) {
            result.append(
                    numChemistry(
                            Integer.parseInt(sb.substring(i - 1, i)),
                            Integer.parseInt(sb.substring(i, i + 1))
                    )
            );
        }
        return chemistry(result);
    }

    private static int numChemistry(int n1, int n2) {
        if (check[n1][n2]) return dp[n1][n2];
        check[n1][n2] = true;
        dp[n1][n2] = (n1 + n2) % 10;
        return dp[n1][n2];
    }
}