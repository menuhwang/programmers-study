import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final Map<Character, char[]> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                char[] row = br.readLine().toCharArray();
                char root = row[0];
                char left = row[2];
                char right = row[4];
                char[] children = new char[]{left, right};
                graph.put(root, children);
            }

            preorder('A');
            bw.write("\n");

            inorder('A');
            bw.write("\n");

            postorder('A');
            bw.write("\n");


            bw.flush();
        }
    }

    private static void preorder(char node) throws IOException {
        bw.write(node);
        for (char child : graph.get(node))
            if (child != '.')
                preorder(child);
    }

    private static void inorder(char node) throws IOException {
        if (node == '.') return;

        char[] children = graph.get(node);
        char left = children[0];
        char right = children[1];

        inorder(left);

        bw.write(node);

        inorder(right);
    }

    private static void postorder(char node) throws IOException {
        if (node == '.') return;

        char[] children = graph.get(node);
        char left = children[0];
        char right = children[1];

        postorder(left);

        postorder(right);

        bw.write(node);
    }
}
