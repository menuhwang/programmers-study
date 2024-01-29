import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] relationship = new boolean[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                String row = br.readLine();
                for (int j = 1; j <= N; j++) {
                    relationship[i][j] = row.charAt(j - 1) == 'Y';
                }
            }

            int max = 0;

            for (int i = 1; i <= N; i++) {
                Set<Integer> friends = new HashSet<>();
                for (int j = 1; j <= N; j++) { // 내 친구
                    if (relationship[i][j])
                        friends.add(j);
                }

                Set<Integer> twoFriends = new HashSet<>();
                for (int friend : friends) {
                    for (int j = 1; j <= N; j++) {
                        if (i != j && relationship[friend][j])
                            twoFriends.add(j);
                    }
                }

                friends.addAll(twoFriends);

                max = Math.max(max, friends.size());
            }

            bw.write(max + "\n");

            bw.flush();
        }
    }
}
