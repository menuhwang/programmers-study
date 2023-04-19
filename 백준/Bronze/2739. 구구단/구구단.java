import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int dan = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            sb.append(String.format("%d * %d = %d\n", dan, i, dan * i));
        }

        System.out.println(sb);
    }
}