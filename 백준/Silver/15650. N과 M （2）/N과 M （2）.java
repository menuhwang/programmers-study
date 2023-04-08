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

        bfs(0, 1);
    }

    private static void bfs(int breadth, int s) {
        if (breadth == M) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = s; i <= N; i++) {
            array[breadth] = i;
            bfs(breadth + 1, i + 1);
        }
    }
}