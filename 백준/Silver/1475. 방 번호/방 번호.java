import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            numbers[N % 10]++;
            N /= 10;
        }

        int sixNine = numbers[6] + numbers[9];
        numbers[6] = sixNine / 2;
        numbers[9] = sixNine - numbers[6];

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
        }

        System.out.println(max);
    }
}