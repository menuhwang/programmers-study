import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            List<Member> members = new ArrayList<>();
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                members.add(new Member(age, name));
            }

            Collections.sort(members);

            for (Member member : members) {
                bw.write(member + "\n");
            }

            bw.flush();
        }
    }

    static class Member implements Comparable<Member> {
        private int age;
        private String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Member o) {
            return Integer.compare(this.age, o.age);
        }
    }
}
