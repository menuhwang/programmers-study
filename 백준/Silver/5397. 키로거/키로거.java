import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String password;
        LinkedList<Character> result;
        ListIterator<Character> iterator;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            password = br.readLine();
            int len = password.length();
            result = new LinkedList<>();
            iterator = result.listIterator();
            for (int c = 0; c < len; c++) {
                char ch = password.charAt(c);
                switch (ch) {
                    case '<':
                        if (iterator.hasPrevious())
                            iterator.previous();
                        break;
                    case '>':
                        if (iterator.hasNext())
                            iterator.next();
                        break;
                    case '-':
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default:
                        iterator.add(ch);
                        break;
                }
            }
            result.forEach(sb::append);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
