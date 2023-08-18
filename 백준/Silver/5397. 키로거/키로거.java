import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String password;
        LinkedList<Character> result;
        int cursor;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            password = br.readLine();
            int len = password.length();
            result = new LinkedList<>();
            cursor = 0;
            for (int c = 0; c < len; c++) {
                char ch = password.charAt(c);
                switch (ch) {
                    case '<':
                        cursor = Math.max(cursor - 1, 0);
                        break;
                    case '>':
                        cursor = Math.min(cursor + 1, result.size());
                        break;
                    case '-':
                        if (cursor == 0) break;
                        result.remove(--cursor);
                        break;
                    default:
                        result.add(cursor++, ch);
                        break;
                }
            }
            result.forEach(sb::append);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
