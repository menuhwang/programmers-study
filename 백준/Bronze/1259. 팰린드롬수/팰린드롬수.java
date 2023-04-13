import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
        
        String string;
        char[] chars;
        boolean flag;
        while (!(string = sc.next()).equals("0")) {
            flag = true;
            chars = string.toCharArray();
            for (int i = chars.length / 2; i > -1; i--) {
                if (chars[i] != chars[chars.length - 1 -i]) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "yes\n" : "no\n");
        }
        
        System.out.print(sb.toString());
    }
}