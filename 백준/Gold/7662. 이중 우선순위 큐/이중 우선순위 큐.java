

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(sc.readLine());

        Solution solution = new Solution();
        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(sc.readLine());
            String[] operations = new String[n];
            for (int j = 0; j < n; j++) {
                operations[j] = sc.readLine();
            }
            solution.solution(operations);
        }
    }
}

class Solution {
    public void solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;

            if (command.equals("I")) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else if (command.equals("D")) {
                if (map.isEmpty()) continue;

                int key;
                if (number == 1) { // Delete max
                    key = map.lastKey();
                } else { // Delete min
                    key = map.firstKey();
                }

                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        if (map.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
}