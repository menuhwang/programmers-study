import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) queue.offer(i);
        
        while (queue.size() > 1) {
            queue.pop();
            queue.offer(queue.pop());
        }
        
        System.out.print(queue.pop());
    }
}