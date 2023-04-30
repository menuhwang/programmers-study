import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        String dir = br.readLine();

        int answer = 0;

        int index = 0;
        while(dir.indexOf("EW", index) > -1) {
            answer++;
            index = dir.indexOf("EW", index) + 1;
        }

        System.out.println(answer);
    }
}