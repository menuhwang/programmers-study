import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int dx = Math.min(x, w - x);
        int dy = Math.min(y, h - y);
        
        System.out.print(Math.min(dx, dy));
    }
}