import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> cnt = new ArrayList<>();

        for (int i = 0; i < 26; i++) cnt.add(0);

        for (char ch : str.toCharArray()) {
            cnt.set(ch - 65, cnt.get(ch - 65) + 1);
        }

        List<Integer> temp = new ArrayList<>(cnt);
        temp.sort(Comparator.reverseOrder());

        int mode = temp.get(0);

        int indexOf = cnt.indexOf(mode);
        int lastIndexOf = cnt.lastIndexOf(mode);

        System.out.println(indexOf != lastIndexOf ? "?" : (char) (indexOf + 65));
    }
}