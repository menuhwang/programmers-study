import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> set = new TreeSet<>((s1, s2) -> {
            if (s1.length() == s2.length()) return CharSequence.compare(s1, s2);
            return Integer.compare(s1.length(), s2.length());
        });

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        StringBuilder sb = new StringBuilder();

        for (String string : set) {
            sb.append(string + "\n");
        }

        System.out.print(sb.toString());
    }
}