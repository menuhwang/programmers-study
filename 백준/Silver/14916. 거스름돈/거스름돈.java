import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int five = N / 5;

        int remainder = 0;
        while(five > -1) {
            if ((N - 5 * five) % 2 == 0) {
                remainder = (N - 5 * five) / 2;
                break;
            }
            five--;
        }
        if (five == -1 && remainder == 0) System.out.print(-1);
        else System.out.println(five + remainder);
    }
}