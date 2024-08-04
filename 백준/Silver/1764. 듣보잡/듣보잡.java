
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str = sc.readLine();
        int n = Integer.parseInt(str.split(" ")[0]) + Integer.parseInt(str.split(" ")[1]);
        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            String str2 = sc.readLine();
            map.put(str2, map.getOrDefault(str2, 0) + 1);
        }

        ArrayList<String> arr = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                count++;
                arr.add(key);
            }
        }
        arr.sort(String::compareTo);

        System.out.println(count);

        for (String key : arr) {
            System.out.println(key);
        }
    }
}