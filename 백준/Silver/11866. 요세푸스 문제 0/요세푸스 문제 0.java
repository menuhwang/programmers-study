import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[N];
        for (int i = 1; i <= N; i++) queue.offer(i);
        
        int index = 0;
        int times = 1;
        int temp;
        while(!queue.isEmpty()) {
            temp = queue.poll();
            if (times++ % K != 0) queue.offer(temp);
            else answer[index++] = temp;
        }
        
        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
            if (i < answer.length - 1) sb.append(", ");
        }
        sb.append(">");
        
        System.out.print(sb.toString());
    }
}