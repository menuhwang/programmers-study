import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            String[] chars = br.readLine().split("");
            List<String> characters = new LinkedList<>(Arrays.asList(chars));

            int M = Integer.parseInt(br.readLine());
            StringTokenizer st;
            ListIterator<String> iterator = characters.listIterator();
            while (iterator.hasNext())
                iterator.next();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                switch (cmd) {
                    case "L":
                        if (iterator.hasPrevious())
                            iterator.previous();
                        break;
                    case "D":
                        if (iterator.hasNext())
                            iterator.next();
                        break;
                    case "B":
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    case "P":
                        iterator.add(st.nextToken());
                        break;
                }
            }

            String result = characters.stream().map(String::valueOf).collect(Collectors.joining());

            bw.write(result);
            bw.newLine();

            bw.flush();
        }
    }
}
