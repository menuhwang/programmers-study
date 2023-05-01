import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int count = 0;
        while (!set.contains(N)) {
            count++;
            set.add(N);
            int tens = onesPlace(N);
            int ones = onesPlace(sumOfDigit(N));
            N = tens * 10 + ones;
        }

        System.out.println(count);
    }

    private static int sumOfDigit(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static int onesPlace(int n) {
        return n % 10;
    }
}