import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> deq = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            deq.offer(i);

        StringBuilder sb = new StringBuilder();
        while (deq.size() > 1) {
            sb.append(deq.poll()).append(" ");
            deq.offer(deq.poll());
        }

        sb.append(deq.poll());

        System.out.println(sb.toString());
    }
}
