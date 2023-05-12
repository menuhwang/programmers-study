import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> results;
    static int[] numbers;
    static boolean[] visited;
    static char[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        br.close();

        operators = new char[N - 1];
        visited = new boolean[N - 1];
        int index = 0;
        for (int i = 0; i < plus; i++) {
            operators[index++] = '+';
        }
        for (int i = 0; i < minus; i++) {
            operators[index++] = '-';
        }
        for (int i = 0; i < mul; i++) {
            operators[index++] = '*';
        }
        for (int i = 0; i < div; i++) {
            operators[index++] = '/';
        }

        results = new ArrayList<>();

        int prev = numbers[0];
        dfs(prev, 0);

        results.sort(Comparator.naturalOrder());

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    private static void dfs(int prev, int depth) {
        if (depth == operators.length) {
            results.add(prev);
            return;
        }
        for (int i = 0; i < operators.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            char operator = operators[i];
            if (operator == '+') {
                dfs(prev + numbers[depth + 1], depth + 1);
                visited[i] = false;
            }
            else if (operator == '-') {
                dfs(prev - numbers[depth + 1], depth + 1);
                visited[i] = false;
            }
            else if (operator == '*') {
                dfs(prev * numbers[depth + 1], depth + 1);
                visited[i] = false;
            }
            else if (operator == '/') {
                dfs(prev / numbers[depth + 1], depth + 1);
                visited[i] = false;
            }
        }
    }
}