import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> rope = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            rope.add(Integer.parseInt(br.readLine()));

        int result = 0;

        while (!rope.isEmpty())
            result = Math.max(result, rope.size() * rope.poll());

        System.out.println(result);
    }
}
