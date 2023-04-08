import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[M];

        dfs(0, 1);
    }

    private static void dfs(int depth, int s) {
        if (depth == M) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = s; i <= N; i++) {
            array[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}
