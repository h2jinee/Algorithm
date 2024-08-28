import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(sc.readLine());

        int[] numbers = new int[10001];

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(sc.readLine());
            numbers[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            while (numbers[i] > 0) {
                sb.append(i).append('\n');
                numbers[i]--;
            }
        }

        System.out.println(sb);
    }
}