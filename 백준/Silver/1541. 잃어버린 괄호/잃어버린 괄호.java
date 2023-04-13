import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-|+", true);

        List<Integer> minus = new ArrayList<>();
        int chunk = 0;

        String token;
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            switch (token) {
                case "-":
                    minus.add(chunk);
                    chunk = 0;
                    break;
                case "+":
                    break;
                default:
                    chunk += Integer.parseInt(token);
                    break;
            }
            if (!st.hasMoreTokens()) minus.add(chunk);
        }

        int answer = minus.get(0);
        for (int i = 1; i < minus.size(); i++) answer -= minus.get(i);
        System.out.print(answer);

        br.close();
    }
}