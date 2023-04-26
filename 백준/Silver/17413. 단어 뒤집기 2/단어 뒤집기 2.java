import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean tagFlag = false;
        boolean buffFlag = false;

        StringBuilder result = new StringBuilder();

        StringBuilder word = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '<') {
                tagFlag = true;
            }
            else if (ch == '>') {
                result.append(ch);
                tagFlag = false;
                continue;
            }

            if (tagFlag && word.length() > 0) {
                insertWord(result, word);
            }

            if (tagFlag) {
                result.append(ch);
            } else if (ch == ' ') {
                insertWord(result, word);
                result.append(' ');
            } else {
                word.append(ch);
            }
        }

        insertWord(result, word);

        System.out.println(result);
    }

    private static void insertWord(StringBuilder target, StringBuilder word) {
        target.append(word.reverse());
        word.delete(0, word.length());
    }
}