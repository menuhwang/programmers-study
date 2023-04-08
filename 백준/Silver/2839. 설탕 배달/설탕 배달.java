import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int weight = sc.nextInt();
        
        int total = -1;
        
        for (int i = weight / 5; i > -1; i--) {
            int remain = weight - 5 * i;
            if (remain % 3 == 0) {
                total = i + remain / 3;
                break;
            }
        }
        
        System.out.print(total);
        
        sc.close();
    }
}