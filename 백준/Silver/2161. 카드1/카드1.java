import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> deq = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            deq.offer(i);

        Stack<Integer> bin = new Stack<>();

        while (deq.size() > 1) {
            bin.push(deq.poll());
            deq.offer(deq.poll());
        }
        StringBuilder sb = new StringBuilder();
        bin.forEach((n) -> sb.append(n).append(" "));
        sb.append(deq.poll());

        System.out.println(sb.toString());
    }
}
