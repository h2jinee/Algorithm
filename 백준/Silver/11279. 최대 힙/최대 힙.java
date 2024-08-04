import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n1 = Integer.parseInt(sc.readLine());
        int[] n2 = new int[n1];

        for (int i = 0; i < n1; i++) {
            n2[i] = Integer.parseInt(sc.readLine());
        }

        for (int i = 0; i < n1; i++) {
            if (n2[i] != 0) {
                pq.add(n2[i]);
            } else if (!pq.isEmpty()){
                System.out.println(pq.poll());
            } else {
                System.out.println(0);
            }
        }
    }
}