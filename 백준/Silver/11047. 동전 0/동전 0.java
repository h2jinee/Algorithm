import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str = sc.readLine();
        int count = Integer.parseInt(str.split(" ")[0]);
        int money = Integer.parseInt(str.split(" ")[1]);
        int result = 0;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < count; i++) {
            set.add(Integer.parseInt(sc.readLine()));
        }

        while (money > 0) {
            if (money >= set.first()) {
                money -= set.first();
                result++;
            } else {
                set.remove(set.first());
            }
        }

        System.out.println(result);
    }
}