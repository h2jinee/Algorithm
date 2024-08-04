
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        String s = sc.readLine();
        int[] str = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int n2 = Integer.parseInt(sc.readLine());
        String s2 = sc.readLine();
        int[] str2 = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> array = new HashMap<>();

        for (int i = 0; i < n; i++) {
            array.put(str[i], array.getOrDefault(str[i], 0) + 1);
        }


        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            if (array.containsKey(str2[i])) {
                answer.append(array.getOrDefault(str2[i], 0) + " ");
            } else {
                answer.append(0 + " ");
            }
        }
        
        // 마지막 공백을 제거하고 결과 출
        System.out.println(answer.toString().trim());

    }
}