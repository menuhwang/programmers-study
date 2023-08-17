import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        int answer = 1;
        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == 'L') i++;
            answer++;
        }

        System.out.println(Math.min(N, answer));
    }
}
