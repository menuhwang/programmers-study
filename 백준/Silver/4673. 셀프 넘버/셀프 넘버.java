public class Main {
    static boolean[] memo;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        memo = new boolean[10001];
        memo[0] = true;
        for (int i = 1; i < 10001; i++) {
            check(i);
        }

        for (int i = 1; i < 10001; i++) {
            if (!memo[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static int d(int n) {
        int result = 0;
        result += n;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    private static void check(int n) {
        n = d(n);
        if (n > 10000 || memo[n]) return;
        memo[n] = true;
        check(d(n));
    }
}