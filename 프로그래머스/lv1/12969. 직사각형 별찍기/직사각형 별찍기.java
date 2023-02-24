import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String row = "*".repeat(a) + "\n";
        String col = row.repeat(b);
        
        System.out.println(col);
    }
}