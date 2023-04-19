import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        printStar(A, 1);

        System.out.println(sb);
    }

    private static void printStar(int n, int i) {
        if (n < i) return;
        sb.append("*".repeat(i));
        sb.append("\n");
        printStar(n, i + 1);
    }
}