import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] array;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[M];
        check = new boolean[N + 1];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == array.length) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (check[i]) continue;
            check[i] = true;
            array[depth] = i;
            dfs(depth + 1);
            check[i] = false;
        }
    }
}