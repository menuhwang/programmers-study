import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Character, Integer> map = new TreeMap<>();

        String str = br.readLine();
        char[] palindrome = new char[str.length()];

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int i = 0;
        while (!map.isEmpty()) {
            char ch = map.firstKey();

            if (map.get(ch) > 1) {
                palindrome[i] = ch;
                palindrome[palindrome.length - 1 - i] = ch;
                i++;
                map.put(ch, map.get(ch) - 2);
            }

            if (map.get(ch) == 1) {
                palindrome[palindrome.length / 2] = ch;
                map.put(ch, map.get(ch) - 1);
            }

            if (map.get(ch) < 1) map.pollFirstEntry();
        }

        String answer = String.valueOf(palindrome);
        System.out.println(answer.indexOf('\0') > -1 ? "I'm Sorry Hansoo" : answer);
    }
}