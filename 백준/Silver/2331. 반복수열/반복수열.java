import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> list = new LinkedList<>();
        list.add(Integer.parseInt(st.nextToken()));
        int P = Integer.parseInt(st.nextToken());

        int count = -1;
        while (true) {
            int num = nextNum(list.getLast(), P);
            count = list.indexOf(num);
            if (count > -1) break;
            list.add(num);
        }
        
        System.out.println(count);
    }

    private static int nextNum(int num, int p) {
        int result = 0;
        while (num > 0) {
            result += (int) Math.pow(num % 10, p);
            num /= 10;
        }
        return result;
    }
}